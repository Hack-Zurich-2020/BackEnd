package hackzurich.proj.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodOrderResponse {
    @JsonProperty("ET")
    private long estimatedTime;
    @JsonProperty("OI")
    private String orderId;
}
