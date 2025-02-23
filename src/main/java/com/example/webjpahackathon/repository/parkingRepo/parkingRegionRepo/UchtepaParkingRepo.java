package com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo;

import com.example.webjpahackathon.model.parking.parkingRegion.UchtepaParking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UchtepaParkingRepo extends JpaRepository<UchtepaParking, UUID> {
    Optional<UchtepaParking> findByName(String name);
}