package abdumalik.dev.myway.repository;

import abdumalik.dev.myway.model.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(@Email String email);

    boolean existsByEmailOrUsername(@Email String email, String username);

}