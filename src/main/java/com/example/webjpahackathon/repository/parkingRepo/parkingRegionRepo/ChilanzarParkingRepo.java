package com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo;

import com.example.webjpahackathon.model.parking.parkingRegion.ChilanzarParking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ChilanzarParkingRepo extends JpaRepository<ChilanzarParking, UUID> {
    Optional<ChilanzarParking> findByName(String name);
}