package com.example.webjpahackathon.repository.stationRepo.gasRepo.regionGasolineStationRepo;

import com.example.webjpahackathon.model.station.gas.regionGasolineStation.OlmazorGasolineStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OlmazorGasolineStationRepo extends JpaRepository<OlmazorGasolineStation, UUID> {
    Optional<OlmazorGasolineStation> findByBrandName(String brandName);
}
