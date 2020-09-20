package hackzurich.proj.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import hackzurich.proj.model.dto.HealthParam;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class GetHealthParamsResponse {
    @JsonProperty("UI")
    private String userId;
    @JsonProperty("HP")
    private Map<Integer, Integer> healthParams;
    @JsonProperty("CC")
    private Integer consumptionCoefficient;
}
