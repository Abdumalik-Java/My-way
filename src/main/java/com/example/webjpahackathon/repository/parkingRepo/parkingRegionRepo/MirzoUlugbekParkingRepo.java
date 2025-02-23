package com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo;

import com.example.webjpahackathon.model.parking.parkingRegion.MirzoUlugbekParking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MirzoUlugbekParkingRepo extends JpaRepository<MirzoUlugbekParking, UUID> {
    Optional<MirzoUlugbekParking> findByName(String name);
}