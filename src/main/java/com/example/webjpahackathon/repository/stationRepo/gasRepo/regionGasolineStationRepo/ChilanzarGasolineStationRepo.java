package com.example.webjpahackathon.repository.stationRepo.gasRepo.regionGasolineStationRepo;

import com.example.webjpahackathon.model.station.gas.regionGasolineStation.ChilanzarGasolineStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ChilanzarGasolineStationRepo extends JpaRepository<ChilanzarGasolineStation, UUID> {
    Optional<ChilanzarGasolineStation> findByBrandName(String brandName);
}
