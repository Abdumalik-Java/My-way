package abdumalik.dev.myway.repository;

import abdumalik.dev.myway.model.CarServices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CarServiceRepo extends JpaRepository<CarServices, UUID> {
    Optional<CarServices> findByServiceName(String serviceName);
    Optional<CarServices> findByLocation(String location);
}