package hackzurich.proj.service;

import hackzurich.proj.config.MainConfig;
import hackzurich.proj.model.Constants;
import hackzurich.proj.model.dto.Food;
import hackzurich.proj.model.dto.Restaurant;
import hackzurich.proj.model.dto.request.FoodFeedbackRequest;
import hackzurich.proj.model.dto.request.FoodInquiryRequest;
import hackzurich.proj.model.dto.request.FoodOrderRequest;
import hackzurich.proj.model.dto.response.FoodInquiryResponse;
import hackzurich.proj.model.dto.response.FoodOrderResponse;
import hackzurich.proj.model.entity.FoodEntity;
import hackzurich.proj.model.entity.OrderEntity;
import hackzurich.proj.model.entity.RestaurantEntity;
import hackzurich.proj.model.entity.UserEntity;
import hackzurich.proj.model.exception.FoodNotFoundException;
import hackzurich.proj.model.exception.OrderNotFoundException;
import hackzurich.proj.model.exception.UserNotFoundException;
import hackzurich.proj.model.repository.FoodRepository;
import hackzurich.proj.model.repository.OrderRepository;
import hackzurich.proj.model.repository.RestaurantRepository;
import hackzurich.proj.model.repository.UserRepository;
import hackzurich.proj.util.CodingUtil;
import hackzurich.proj.util.GenIdUtil;
import hackzurich.proj.util.LocationUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class FoodService {
    private FoodRepository foodRepository;
    private UserRepository userRepository;
    private MainConfig mainConfig;
    private PythonService pythonService;
    private OrderRepository orderRepository;
    private RestaurantRepository restaurantRepository;

    public FoodInquiryResponse foodInquiry(FoodInquiryRequest request) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserName(request.getUserId());
        if (optionalUserEntity.isEmpty())
            throw new UserNotFoundException();
        UserEntity userEntity = optionalUserEntity.get();
        String categoryIdsStr = pythonService.getFoodCategories(userEntity.getHealthParams());
        List<FoodEntity> foodEntities = foodRepository.findAllByCategoryIdsContainsAndTypeEquals(categoryIdsStr,
                request.getFoodType());
        List<Food> foods = new ArrayList<>();
        Map<Long, Restaurant> foodRestaurantMap = new HashMap<>();
        foodEntities.forEach(foodEntity -> {
            RestaurantEntity restaurantEntity = foodEntity.getRestaurantEntity();
            double distance = LocationUtil.calcDistance(request.getLatitude(), request.getLongitude(),
                    restaurantEntity.getLatitude(), restaurantEntity.getLongitude());
            if (distance <= mainConfig.getMaxDistanceKm()) {
                Restaurant restaurant = new Restaurant(restaurantEntity.getName(), distance,
                        CodingUtil.strToIntList(restaurantEntity.getCategoryIds()), restaurantEntity.getScore());
                Food food = new Food(foodEntity.getName(), foodEntity.getId(), foodEntity.getPrice(),
                        CodingUtil.strToIntKeyMap(foodEntity.getNutritionFacts()),
                        CodingUtil.strToIntList(categoryIdsStr), foodEntity.getAmount(),
                        CodingUtil.strToStrKeyMap(foodEntity.getIngredients()), foodEntity.getType(), foodEntity.getScore());
                foods.add(food);
                foodRestaurantMap.put(food.getId(), restaurant);
            }
        });
        foods.sort((f1, f2) -> {
            if (f1.getFoodScore().equals(f2.getFoodScore()))
                return 0;
            return f1.getFoodScore() > f2.getFoodScore() ? 1 : -1;
        });
        return new FoodInquiryResponse(CodingUtil.strToIntKeyMap(userEntity.getHealthParams()), foods, foodRestaurantMap);
    }

    public FoodOrderResponse foodOrder(FoodOrderRequest request) {
        Optional<UserEntity> userEntityOptional = userRepository.findByUserName(request.getUserId());
        if (userEntityOptional.isEmpty())
            throw new UserNotFoundException();
        UserEntity userEntity = userEntityOptional.get();
        Map<String, Integer> orderMap = new HashMap<>();
        request.getFoodIds().forEach(foodId -> {
            Optional<FoodEntity> foodEntityOptional = foodRepository.findById(foodId);
            if (foodEntityOptional.isEmpty())
                throw new FoodNotFoundException();
            FoodEntity foodEntity = foodEntityOptional.get();
            orderMap.put(foodEntity.getName(), foodEntity.getAmount());
        });
        String orderId = GenIdUtil.genId(Constants.ORDER_ID_LEN);
        OrderEntity orderEntity = new OrderEntity(orderId, Constants.NO_VALUE, Constants.NO_VALUE,
                CodingUtil.strMapToStr(orderMap), false, userEntity);
        orderRepository.save(orderEntity);
        return new FoodOrderResponse(mainConfig.getEstimatedTime(), orderId, orderMap);
    }

    public void finalizeOrder(String orderId) {
        Optional<OrderEntity> orderEntityOptional = orderRepository.findById(orderId);
        if (orderEntityOptional.isEmpty())
            throw new OrderNotFoundException();
        OrderEntity orderEntity = orderEntityOptional.get();
        orderEntity.setFinalized(true);
        orderRepository.save(orderEntity);
    }

    public void receiveFeedback(FoodFeedbackRequest request) {
        Optional<OrderEntity> orderEntityOptional = orderRepository.findById(request.getOrderId());
        if (orderEntityOptional.isEmpty())
            throw new OrderNotFoundException();
        OrderEntity orderEntity = orderEntityOptional.get();
        orderEntity.setWasteAmount(request.getWastedAmount());
        orderEntity.setWasteCause(request.getWasteCause());
        orderRepository.save(orderEntity);
        request.getFoodRate().forEach(this::updateScores);
    }

    private void updateScores(long foodId, int score) {
        Optional<FoodEntity> foodEntityOptional = foodRepository.findById(foodId);
        if (foodEntityOptional.isEmpty())
            throw new FoodNotFoundException();
        FoodEntity foodEntity = foodEntityOptional.get();
        int ordersCount = foodEntity.getOrdersCount();
        foodEntity.setScore((foodEntity.getScore() * ordersCount + score) / (ordersCount + 1));
        foodEntity.setOrdersCount(ordersCount + 1);
        foodRepository.save(foodEntity);
        RestaurantEntity restaurantEntity = foodEntity.getRestaurantEntity();
        ordersCount = restaurantEntity.getOrdersCount();
        restaurantEntity.setScore((restaurantEntity.getScore() * ordersCount + score) / (ordersCount + 1));
        restaurantEntity.setOrdersCount(ordersCount + 1);
        restaurantRepository.save(restaurantEntity);
    }
}