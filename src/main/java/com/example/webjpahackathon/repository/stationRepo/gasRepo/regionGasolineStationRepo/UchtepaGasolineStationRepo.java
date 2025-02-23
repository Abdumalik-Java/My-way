package com.example.webjpahackathon.repository.stationRepo.gasRepo.regionGasolineStationRepo;

import com.example.webjpahackathon.model.station.gas.regionGasolineStation.UchtepaGasolineStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UchtepaGasolineStationRepo extends JpaRepository<UchtepaGasolineStation, UUID> {
    Optional<UchtepaGasolineStation> findByBrandName(String brandName);
}
