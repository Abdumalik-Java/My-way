package abdumalik.dev.myway.repository;

import abdumalik.dev.myway.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ParkingRepo extends JpaRepository<Parking, UUID> {
    Optional<Parking> findByName(String name);
    Optional<Parking> findByLocation(String location);
}