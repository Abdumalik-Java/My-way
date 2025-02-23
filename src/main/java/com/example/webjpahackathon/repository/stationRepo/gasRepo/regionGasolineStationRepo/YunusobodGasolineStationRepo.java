package com.example.webjpahackathon.repository.stationRepo.gasRepo.regionGasolineStationRepo;

import com.example.webjpahackathon.model.station.gas.regionGasolineStation.YunusobodGasolineStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YunusobodGasolineStationRepo extends JpaRepository<YunusobodGasolineStation, UUID> {
    Optional<YunusobodGasolineStation> findByBrandName(String brandName);
}
