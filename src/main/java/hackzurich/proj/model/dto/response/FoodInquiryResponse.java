package hackzurich.proj.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import hackzurich.proj.model.dto.Food;
import hackzurich.proj.model.dto.HealthParam;
import hackzurich.proj.model.dto.Restaurant;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class FoodInquiryResponse {
    //User's health parameters for debugging
    @JsonProperty("HP")
    private List<Integer> healthParams;
    @JsonProperty("FRM")
    private Map<Food, Restaurant> foodRestaurantMap;
}
