package abdumalik.dev.myway.repository;

import abdumalik.dev.myway.model.Car;
import abdumalik.dev.myway.model.Details;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DetailsRepo extends JpaRepository<Details, UUID> {
    Optional<Details> findByDetailName(String detailName);
    Optional<Details> findByCar(Car car);
}