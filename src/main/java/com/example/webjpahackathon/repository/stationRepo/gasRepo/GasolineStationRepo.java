package com.example.webjpahackathon.repository.stationRepo.gasRepo;

import com.example.webjpahackathon.model.station.gas.GasolineStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GasolineStationRepo extends JpaRepository<GasolineStation, UUID> {
    Optional<GasolineStation> findByBrandName(String brandName);
}
