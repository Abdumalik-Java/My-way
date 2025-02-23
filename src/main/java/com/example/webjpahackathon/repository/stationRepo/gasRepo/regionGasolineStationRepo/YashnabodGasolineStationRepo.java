package com.example.webjpahackathon.repository.stationRepo.gasRepo.regionGasolineStationRepo;

import com.example.webjpahackathon.model.station.gas.regionGasolineStation.YashnabodGasolineStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YashnabodGasolineStationRepo extends JpaRepository<YashnabodGasolineStation, UUID> {
    Optional<YashnabodGasolineStation> findByBrandName(String brandName);
}
