package com.example.webjpahackathon.repository.stationRepo.gasRepo.regionGasolineStationRepo;

import com.example.webjpahackathon.model.station.gas.regionGasolineStation.ShayxontohurGasolineStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ShayxontohurGasolineStationRepo extends JpaRepository<ShayxontohurGasolineStation, UUID> {
    Optional<ShayxontohurGasolineStation> findByBrandName(String brandName);
}
