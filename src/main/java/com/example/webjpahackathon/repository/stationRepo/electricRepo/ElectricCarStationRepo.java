package com.example.webjpahackathon.repository.stationRepo.electricRepo;

import com.example.webjpahackathon.model.station.electric.ElectricCarStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ElectricCarStationRepo extends JpaRepository<ElectricCarStation, UUID> {
    Optional<ElectricCarStation> findByBrandName(String brandName);
}
