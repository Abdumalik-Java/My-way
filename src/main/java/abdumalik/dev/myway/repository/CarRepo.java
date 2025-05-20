package abdumalik.dev.myway.repository;

import abdumalik.dev.myway.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepo extends JpaRepository<Car, UUID> {
}