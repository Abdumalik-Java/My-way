package com.example.webjpahackathon.repository.stationRepo.electricRepo.chargerRepo;

import com.example.webjpahackathon.model.station.electric.charger.Fast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FastRepo extends JpaRepository<Fast, UUID> {
    Optional<Fast> findByName(String name);
}
