package com.example.webjpahackathon.repository.stationRepo.gasRepo.regionGasolineStationRepo;

import com.example.webjpahackathon.model.station.gas.regionGasolineStation.MirzoUlugbekGasolineStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MirzoUlugbekGasolineStationRepo extends JpaRepository<MirzoUlugbekGasolineStation, UUID> {
    Optional<MirzoUlugbekGasolineStation> findByBrandName(String brandName);
}
