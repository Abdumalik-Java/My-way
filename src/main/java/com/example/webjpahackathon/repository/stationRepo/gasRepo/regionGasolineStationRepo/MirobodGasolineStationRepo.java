package com.example.webjpahackathon.repository.stationRepo.gasRepo.regionGasolineStationRepo;

import com.example.webjpahackathon.model.station.gas.regionGasolineStation.MirobodGasolineStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MirobodGasolineStationRepo extends JpaRepository<MirobodGasolineStation, UUID> {
    Optional<MirobodGasolineStation> findByBrandName(String brandName);
}
