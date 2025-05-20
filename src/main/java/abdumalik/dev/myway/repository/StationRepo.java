package abdumalik.dev.myway.repository;

import abdumalik.dev.myway.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StationRepo extends JpaRepository<Station, UUID> {
    Optional<Station> findByStationType(String stationType);
    Optional<Station> findByStationName(String stationName);
    Optional<Station> findByLocation(String location);
}