package hackzurich.proj.service;

import hackzurich.proj.model.Constants;
import hackzurich.proj.model.dto.request.CreateUserRequest;
import hackzurich.proj.model.entity.UserEntity;
import hackzurich.proj.model.exception.UserExistingException;
import hackzurich.proj.model.repository.UserRepository;
import hackzurich.proj.util.CodingUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public void createUser(CreateUserRequest request){
        UserEntity userEntity = new UserEntity(request.getId(), CodingUtil.intMapToStr(request.getHealthParams()),
                request.getInitialBalance());
        if (userRepository.findById(request.getId()).isPresent())
            throw new UserExistingException();
        userRepository.save(userEntity);
    }

}
