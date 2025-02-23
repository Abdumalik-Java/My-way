package com.example.webjpahackathon.repository.stationRepo.electricRepo.regionElectricStationRepo;

import com.example.webjpahackathon.model.station.electric.regionElectricStation.YunusobodElectricStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YunusobodElectricStationRepo extends JpaRepository<YunusobodElectricStation, UUID> {
    Optional<YunusobodElectricStation> findByBrandName(String brandName);
}
