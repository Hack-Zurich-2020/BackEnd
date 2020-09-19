package hackzurich.proj.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class FoodOrderResponse {
    @JsonProperty("ET")
    private long estimatedTime;
    @JsonProperty("OI")
    private String orderId;
    @JsonProperty("OM")
    private Map<String, Integer> orderMap;
}
