package com.example.webjpahackathon.repository.stationRepo.gasRepo.regionGasolineStationRepo;

import com.example.webjpahackathon.model.station.gas.regionGasolineStation.YakkasaroyGasolineStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YakkasaroyGasolineStationRepo extends JpaRepository<YakkasaroyGasolineStation, UUID> {
    Optional<YakkasaroyGasolineStation> findByBrandName(String brandName);
}
