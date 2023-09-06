package az.ingress.msauthuser.mapper;

import az.ingress.msauthuser.dao.entity.UserEntity;
import az.ingress.msauthuser.dto.request.SaveUserRequest;
import az.ingress.msauthuser.dto.response.UserResponse;
import az.ingress.msauthuser.enums.UserStatus;

import java.time.LocalDateTime;

public class UserMapper {
    public static UserEntity buildToEntity(SaveUserRequest request) {
        return UserEntity.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .createdAt(LocalDateTime.now())
                .status(UserStatus.ACTIVE)
                .build();
    }

    public static UserResponse buildToResponse(UserEntity user) {
        return UserResponse.builder()
                .id(user.getId())
                .build();
    }


}
