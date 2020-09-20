package hackzurich.proj.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class WasteStatisticsResponse {
    @JsonProperty("WM")
    private Map<Integer, Double> wasteMap;
    @JsonProperty("WC")
    private Map<Integer, Double> wastePrice;
}
