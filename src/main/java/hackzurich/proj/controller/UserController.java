package hackzurich.proj.controller;

import hackzurich.proj.model.dto.request.CreateUserRequest;
import hackzurich.proj.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/user/register")
    public void registerUser(@RequestBody CreateUserRequest request){
        userService.createUser(request);
    }
}
