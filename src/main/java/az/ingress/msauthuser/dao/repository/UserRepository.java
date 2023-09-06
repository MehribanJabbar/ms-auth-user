package az.ingress.msauthuser.dao.repository;

import az.ingress.msauthuser.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
        UserEntity findByUsername(String username);
}
