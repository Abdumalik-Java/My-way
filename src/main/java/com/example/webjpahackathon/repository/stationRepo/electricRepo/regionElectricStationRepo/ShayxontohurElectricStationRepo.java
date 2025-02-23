package com.example.webjpahackathon.repository.stationRepo.electricRepo.regionElectricStationRepo;

import com.example.webjpahackathon.model.station.electric.regionElectricStation.ShayxontohurElectricStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ShayxontohurElectricStationRepo extends JpaRepository<ShayxontohurElectricStation, UUID> {
    Optional<ShayxontohurElectricStation> findByBrandName(String brandName);
}
