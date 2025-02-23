package com.example.webjpahackathon.repository.stationRepo.electricRepo.regionElectricStationRepo;

import com.example.webjpahackathon.model.station.electric.regionElectricStation.YashnabodElectricStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YashnabodElectricStationRepo extends JpaRepository<YashnabodElectricStation, UUID> {
    Optional<YashnabodElectricStation> findByBrandName(String brandName);
}
