package com.example.webjpahackathon.repository.stationRepo.electricRepo.chargerRepo;

import com.example.webjpahackathon.model.station.electric.charger.Slow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SlowRepo extends JpaRepository<Slow, UUID> {
    Optional<Slow> findByName(String name);
}
