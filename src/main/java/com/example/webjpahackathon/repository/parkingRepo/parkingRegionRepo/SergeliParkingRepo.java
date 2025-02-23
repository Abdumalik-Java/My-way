package com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo;

import com.example.webjpahackathon.model.parking.parkingRegion.SergeliParking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SergeliParkingRepo extends JpaRepository<SergeliParking, UUID> {
    Optional<SergeliParking> findByName(String name);
}