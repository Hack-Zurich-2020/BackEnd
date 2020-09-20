package hackzurich.proj.controller;

import hackzurich.proj.model.dto.request.CreateUserRequest;
import hackzurich.proj.model.dto.request.UpdateUserHealthParamsRequest;
import hackzurich.proj.model.dto.response.GetHealthParamsResponse;
import hackzurich.proj.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
public class UserController {
    private UserService userService;

    @PostMapping("/user/register")
    public void registerUser(@RequestBody CreateUserRequest request){
        userService.createUser(request);
    }

    @GetMapping("/user/get_health_params")
    public GetHealthParamsResponse getUserHealthParams(@RequestParam(name = "userId") String userId){
        return userService.getUserHealthParams(userId);
    }

    @PostMapping("/user/update_health_params")
    public GetHealthParamsResponse updateHealthParams(@RequestBody UpdateUserHealthParamsRequest request){
        return userService.updateUserHealthParams(request);
    }
}
