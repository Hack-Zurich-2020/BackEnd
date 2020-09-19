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
    @JsonProperty("FI")
    private Long id;
    @JsonProperty("FP")
    private Integer price;
    @JsonProperty("NF")
    private Map<Integer, Integer> nutritionFacts;
    @JsonProperty("FC")
    private List<Integer> foodCategoryIds;
    @JsonProperty("FA")
    private Integer amount;
}
