package com.example.webjpahackathon.repository.stationRepo.electricRepo.regionElectricStationRepo;

import com.example.webjpahackathon.model.station.electric.regionElectricStation.YakkasaroyElectricStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YakkasaroyElectricStationRepo extends JpaRepository<YakkasaroyElectricStation, UUID> {
    Optional<YakkasaroyElectricStation> findByBrandName(String brandName);
}
