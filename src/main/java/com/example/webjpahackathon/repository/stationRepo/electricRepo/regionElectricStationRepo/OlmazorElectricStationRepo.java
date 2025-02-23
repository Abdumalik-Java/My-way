package com.example.webjpahackathon.repository.stationRepo.electricRepo.regionElectricStationRepo;

import com.example.webjpahackathon.model.station.electric.regionElectricStation.OlmazorElectricStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OlmazorElectricStationRepo extends JpaRepository<OlmazorElectricStation, UUID> {
    Optional<OlmazorElectricStation> findByBrandName(String brandName);
}
