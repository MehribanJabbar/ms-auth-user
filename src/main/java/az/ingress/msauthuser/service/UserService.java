package az.ingress.msauthuser.service;

import az.ingress.msauthuser.dao.repository.UserRepository;
import az.ingress.msauthuser.dto.request.SaveUserRequest;
import az.ingress.msauthuser.dto.response.UserResponse;
import az.ingress.msauthuser.enums.UserStatus;
import az.ingress.msauthuser.exception.NotFoundException;
import az.ingress.msauthuser.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static az.ingress.msauthuser.mapper.UserMapper.buildToEntity;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserResponse getUserById(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        return UserMapper.buildToResponse(user);
    }

    public UserResponse getUserByUsername(String username){
        var user = userRepository.findByUsername(username);
        return UserMapper.buildToResponse(user);
    }

    public void saveUser(SaveUserRequest request) {
        userRepository.save(buildToEntity(request));
    }

    public void deleteUser(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        user.setStatus(UserStatus.DELETED);
        userRepository.save(user);
    }
}
