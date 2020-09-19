package hackzurich.proj.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateUserRequest {
    @JsonProperty("ID")
    private String id;
    private Map<Integer, Integer> healthParams;
    @JsonProperty("IB")
    private int initialBalance;
}
