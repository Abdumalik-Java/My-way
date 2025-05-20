package abdumalik.dev.myway.repository;

import abdumalik.dev.myway.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoginRepo extends JpaRepository<Login, UUID> {
    boolean existsByEmailOrUsername(String email, String username);
}