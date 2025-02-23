package com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo;

import com.example.webjpahackathon.model.parking.parkingRegion.BektemirParking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BektemirParkingRepo extends JpaRepository<BektemirParking, UUID> {
    Optional<BektemirParking> findByName(String name);
}