package com.example.webjpahackathon.repository.stationRepo.electricRepo.regionElectricStationRepo;

import com.example.webjpahackathon.model.station.electric.regionElectricStation.MirobodElectricStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MirobodElectricStationRepo extends JpaRepository<MirobodElectricStation, UUID> {
    Optional<MirobodElectricStation> findByBrandName(String brandName);
}