package com.example.webjpahackathon.repository.stationRepo.electricRepo.regionElectricStationRepo;

import com.example.webjpahackathon.model.station.electric.regionElectricStation.MirzoUlugbekElectricStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MirzoUlugbekElectricStationRepo extends JpaRepository<MirzoUlugbekElectricStation, UUID> {
    Optional<MirzoUlugbekElectricStation> findByBrandName(String brandName);
}
