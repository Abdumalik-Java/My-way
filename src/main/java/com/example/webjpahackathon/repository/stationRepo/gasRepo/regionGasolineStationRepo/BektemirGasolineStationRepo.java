package com.example.webjpahackathon.repository.stationRepo.gasRepo.regionGasolineStationRepo;

import com.example.webjpahackathon.model.station.gas.regionGasolineStation.BektemirGasolineStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BektemirGasolineStationRepo extends JpaRepository<BektemirGasolineStation, UUID> {
    Optional<BektemirGasolineStation> findByBrandName(String brandName);
}
