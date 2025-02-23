package com.example.webjpahackathon.repository.stationRepo.electricRepo.regionElectricStationRepo;

import com.example.webjpahackathon.model.station.electric.regionElectricStation.BektemirElectricStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BektemirElectricStationRepo extends JpaRepository<BektemirElectricStation, UUID> {
    Optional<BektemirElectricStation> findByBrandName(String brandName);
}
