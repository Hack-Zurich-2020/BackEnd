package hackzurich.proj.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FoodFeedbackRequest {
    @JsonProperty("OI")
    private String orderId;
    @JsonProperty("FR")
    private Map<Long,Integer> foodRate;
    @JsonProperty("WA")
    private Integer wastedAmount;
    @JsonProperty("WC")
    private Integer wasteCause;
}
