package hackzurich.proj.service;

import hackzurich.proj.config.MainConfig;
import hackzurich.proj.model.Constants;
import hackzurich.proj.model.dto.Food;
import hackzurich.proj.model.dto.Restaurant;
import hackzurich.proj.model.dto.request.FoodInquiryRequest;
import hackzurich.proj.model.dto.request.FoodOrderRequest;
import hackzurich.proj.model.dto.response.FoodInquiryResponse;
import hackzurich.proj.model.dto.response.FoodOrderResponse;
import hackzurich.proj.model.entity.FoodEntity;
import hackzurich.proj.model.entity.RestaurantEntity;
import hackzurich.proj.model.entity.UserEntity;
import hackzurich.proj.model.exception.UserNotFoundException;
import hackzurich.proj.model.repository.FoodRepository;
import hackzurich.proj.model.repository.UserRepository;
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

    public FoodInquiryResponse foodInquiry(FoodInquiryRequest request) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(request.getUserId());
        if (optionalUserEntity.isEmpty())
            throw new UserNotFoundException();
        UserEntity userEntity = optionalUserEntity.get();
        String categoryIdsStr = pythonService.getFoodCategories(userEntity.getHealthParams());
        List<FoodEntity> foodEntities = foodRepository.findAllByCategoryIdsContains(categoryIdsStr);
        List<Food> foods = new ArrayList<>();
        Map<Long, Restaurant> foodRestaurantMap = new HashMap<>();
        foodEntities.forEach(foodEntity -> {
            RestaurantEntity restaurantEntity = foodEntity.getRestaurantEntity();
            double distance = LocationUtil.calcDistance(request.getLatitude(), request.getLongitude(),
                    restaurantEntity.getLatitude(), restaurantEntity.getLongitude());
            if (distance <= mainConfig.getMaxDistanceKm()) {
                Restaurant restaurant = new Restaurant(restaurantEntity.getName(), distance,
                        getListCategoryIds(restaurantEntity.getCategoryIds()));
                Food food = new Food(foodEntity.getId(), foodEntity.getPrice(),
                        getMapNutritionFactsFromStr(foodEntity.getNutritionFacts()),
                        getListCategoryIds(categoryIdsStr), foodEntity.getAmount(),
                        getMapIngredientsFromStr(foodEntity.getIngredients()), foodEntity.getType());
                foods.add(food);
                foodRestaurantMap.put(food.getId(), restaurant);
            }
        });
        return new FoodInquiryResponse(getListCategoryIds(userEntity.getHealthParams()), foods, foodRestaurantMap);
    }

/*
    public FoodOrderResponse foodOrder(FoodOrderRequest request){
        Map<String, Integer> orderMap = new HashMap<>();
        request.getFoodIds().forEach(foodId -> {
            Optional<FoodEntity> foodEntityOptional = foodRepository.findById(foodId);
            if
            FoodEntity foodEntity =
        });
    }
*/

    private String getStrCategoryIds(List<Integer> ids) {
        StringBuilder categoryIds = new StringBuilder();
        ids.forEach(id -> categoryIds.append(id).append(","));
        return categoryIds.substring(0, categoryIds.length() - 1);
    }

    private List<Integer> getListCategoryIds(String categoryIdsStr) {
        List<Integer> returnedCategoryIds = new ArrayList<>();
        Arrays.asList(categoryIdsStr.split(",")).forEach(strId -> returnedCategoryIds.add(Integer.parseInt(strId)));
        return returnedCategoryIds;
    }

    private Map<String, Integer> getMapIngredientsFromStr(String factsStr) {
        Map<String, Integer> nutritionFactsMap = new HashMap<>();
        for (String each : factsStr.split(Constants.COMMA)) {
            nutritionFactsMap.put(each.split(Constants.COLON)[0], Integer.parseInt(each.split(Constants.COLON)[1]));
        }
        return nutritionFactsMap;
    }

    private Map<Integer, Integer> getMapNutritionFactsFromStr(String factsStr) {
        Map<Integer, Integer> nutritionFactsMap = new HashMap<>();
        for (String each : factsStr.split(Constants.COMMA)) {
            nutritionFactsMap.put(Integer.parseInt(each.split(Constants.COLON)[0]), Integer.parseInt(each.split(Constants.COLON)[1]));
        }
        return nutritionFactsMap;
    }
}