package com.example.webjpahackathon.repository.stationRepo.gasRepo.regionGasolineStationRepo;

import com.example.webjpahackathon.model.station.gas.regionGasolineStation.SergeliGasolineStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SergeliGasolineStationRepo extends JpaRepository<SergeliGasolineStation, UUID> {
    Optional<SergeliGasolineStation> findByBrandName(String brandName);
}
