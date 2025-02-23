package com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo;

import com.example.webjpahackathon.model.parking.parkingRegion.YashnabodParking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YashnabodParkingRepo extends JpaRepository<YashnabodParking, UUID> {
    Optional<YashnabodParking> findByName(String name);
}
