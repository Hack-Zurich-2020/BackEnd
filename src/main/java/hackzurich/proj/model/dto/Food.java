package hackzurich.proj.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Food {
    @JsonProperty("FN")
    private String foodName;
    @JsonProperty("FI")
    private Long id;
    @JsonProperty("FP")
    private Integer price;
    //NutritionFact:ApproximateAmount
    @JsonProperty("NF")
    private Map<Integer, Integer> nutritionFacts;
    //FoodCategory
    @JsonProperty("FC")
    private List<Integer> foodCategoryIds;
    @JsonProperty("FA")
    private Integer amount;
    //List of ingredients
    @JsonProperty("IN")
    private Map<String, Integer> ingredients;
    //FoodType
    @JsonProperty("FT")
    private Integer foodType;
    @JsonProperty("FS")
    private Double foodScore;
}
