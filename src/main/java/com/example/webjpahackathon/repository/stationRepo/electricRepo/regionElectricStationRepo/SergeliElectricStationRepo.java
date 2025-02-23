package com.example.webjpahackathon.repository.stationRepo.electricRepo.regionElectricStationRepo;

import com.example.webjpahackathon.model.station.electric.regionElectricStation.SergeliElectricStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SergeliElectricStationRepo extends JpaRepository<SergeliElectricStation, UUID> {
    Optional<SergeliElectricStation> findByBrandName(String brandName);
}
