package abdumalik.dev.myway.repository;

import abdumalik.dev.myway.model.CarWash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CarWashRepo extends JpaRepository<CarWash, UUID> {
    Optional<CarWash> findByName(String name);
    Optional<CarWash> findByLocation(String location);
}