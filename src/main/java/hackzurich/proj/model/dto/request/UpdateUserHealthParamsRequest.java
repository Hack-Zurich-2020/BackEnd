package hackzurich.proj.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateUserHealthParamsRequest {
    @JsonProperty("ID")
    private String id;
    @JsonProperty("HP")
    private Map<Integer, Integer> healthParams;
}
