package hackzurich.proj.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import hackzurich.proj.model.dto.Food;
import hackzurich.proj.model.dto.Restaurant;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class FoodInquiryResponse {
    @JsonProperty("F")
    private List<Food> foods;
    @JsonProperty("FRM")
    private Map<Long, Restaurant> foodRestaurantMap;
}
