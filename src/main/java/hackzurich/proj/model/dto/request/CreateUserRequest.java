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
public class CreateUserRequest extends UpdateUserHealthParamsRequest{
    @JsonProperty("IB")
    private int initialBalance;
}
