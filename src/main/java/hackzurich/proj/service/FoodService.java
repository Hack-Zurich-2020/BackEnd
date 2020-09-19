package hackzurich.proj.service;

import hackzurich.proj.config.MainConfig;
import hackzurich.proj.model.Constants;
import hackzurich.proj.model.dto.Food;
import hackzurich.proj.model.dto.Restaurant;
import hackzurich.proj.model.dto.request.FoodInquiryRequest;
import hackzurich.proj.model.dto.response.FoodInquiryResponse;
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

    public FoodInquiryResponse foodInquiry(FoodInquiryRequest request) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(request.getUserId());
        if (!optionalUserEntity.isPresent())
            throw new UserNotFoundException();
        UserEntity userEntity = optionalUserEntity.get();
        String categoryIdsStr = getStrCategoryIds(request.getCategoryIds());
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
                Food food = new Food(foodEntity.getId(), foodEntity.getPrice(), getMapNutritionFacts(foodEntity.getNutritionFacts()),
                        getListCategoryIds(categoryIdsStr), foodEntity.getAmount());
                foods.add(food);
                foodRestaurantMap.put(food.getId(), restaurant);
            }
        });
        return new FoodInquiryResponse(foods, foodRestaurantMap);
    }

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

    private Map<Integer, Integer> getMapNutritionFacts(String factsStr) {
        Map<Integer, Integer> nutritionFactsMap = new HashMap<>();
        for (String each : factsStr.split(Constants.COMMA))
            nutritionFactsMap.put(Integer.parseInt(each.split(Constants.COLON)[0]), Integer.parseInt(each.split(Constants.COLON)[1]));
        return nutritionFactsMap;
    }
}