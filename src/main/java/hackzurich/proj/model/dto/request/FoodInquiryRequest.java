package hackzurich.proj.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FoodInquiryRequest {
    @JsonProperty("UI")
    private String userId;
    @JsonProperty("FT")
    private Integer foodType;
    @JsonProperty("LO")
    private Double longitude;
    @JsonProperty("LA")
    private Double latitude;
}
