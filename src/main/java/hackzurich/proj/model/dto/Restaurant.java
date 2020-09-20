package hackzurich.proj.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @JsonProperty("N")
    private String name;
    @JsonProperty("D")
    private Double distance;
    @JsonProperty("RC")
    private List<Integer> restaurantCategories;
    @JsonProperty("RS")
    private Double restaurantScore;
}
