package com.example.webjpahackathon.repository.stationRepo.electricRepo.regionElectricStationRepo;

import com.example.webjpahackathon.model.station.electric.regionElectricStation.UchtepaElectricStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UchtepaElectricStationRepo extends JpaRepository<UchtepaElectricStation, UUID> {
    Optional<UchtepaElectricStation> findByBrandName(String brandName);
}
