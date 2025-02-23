package com.example.webjpahackathon.repository.stationRepo.gasRepo.regionGasolineStationRepo;

import com.example.webjpahackathon.model.station.gas.regionGasolineStation.YangihayotGasolineStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YangihayotGasolineStationRepo extends JpaRepository<YangihayotGasolineStation, UUID> {
    Optional<YangihayotGasolineStation> findByBrandName(String brandName);
}
