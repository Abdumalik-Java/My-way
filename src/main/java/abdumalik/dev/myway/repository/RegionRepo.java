package abdumalik.dev.myway.repository;

import abdumalik.dev.myway.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RegionRepo extends JpaRepository<Region, UUID> {
    Optional<Region> findByName(String name);
}