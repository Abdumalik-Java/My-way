package com.example.webjpahackathon.repository.stationRepo.electricRepo.regionElectricStationRepo;

import com.example.webjpahackathon.model.station.electric.regionElectricStation.YangihayotElectricStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YangihayotElectricStationRepo extends JpaRepository<YangihayotElectricStation, UUID> {
    Optional<YangihayotElectricStation> findByBrandName(String brandName);
}
