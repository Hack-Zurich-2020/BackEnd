package hackzurich.proj.service;

import hackzurich.proj.model.Constants;
import hackzurich.proj.model.dto.request.CreateUserRequest;
import hackzurich.proj.model.dto.response.GetHealthParamsResponse;
import hackzurich.proj.model.entity.UserEntity;
import hackzurich.proj.model.exception.UserExistingException;
import hackzurich.proj.model.exception.UserNotFoundException;
import hackzurich.proj.model.repository.UserRepository;
import hackzurich.proj.util.CodingUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

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

    public GetHealthParamsResponse getUserHealthParams(String userId){
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        if (userEntityOptional.isEmpty())
            throw new UserNotFoundException();
        UserEntity userEntity = userEntityOptional.get();
        return new GetHealthParamsResponse(userId, CodingUtil.strToIntKeyMap(userEntity.getHealthParams()));
    }

    public GetHealthParamsResponse updateUserHealthParams(String userId, Map<Integer, Integer> healthParams){
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        if (userEntityOptional.isEmpty())
            throw new UserNotFoundException();
        UserEntity userEntity = userEntityOptional.get();
        userEntity.setHealthParams(CodingUtil.intMapToStr(healthParams));
        userRepository.save(userEntity);
        return new GetHealthParamsResponse(userId, healthParams);
    }

}
