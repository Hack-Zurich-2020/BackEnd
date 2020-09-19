package hackzurich.proj.service;

import hackzurich.proj.model.Constants;
import hackzurich.proj.model.dto.request.CreateUserRequest;
import hackzurich.proj.model.entity.UserEntity;
import hackzurich.proj.model.exception.UserExistingException;
import hackzurich.proj.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public void createUser(CreateUserRequest request){
        StringBuilder healthParams = new StringBuilder();
        request.getHealthParams().forEach((k,v) -> healthParams.append(k).append(Constants.COLON).append(v).
                append(Constants.COMMA));
        UserEntity userEntity = new UserEntity(request.getId(), healthParams.substring(0, healthParams.length() - 1),
                request.getInitialBalance());
        if (userRepository.findById(request.getId()).isPresent())
            throw new UserExistingException();
        userRepository.save(userEntity);
    }

}
