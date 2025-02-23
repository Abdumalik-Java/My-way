package com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo;

import com.example.webjpahackathon.model.parking.parkingRegion.YangihayotParking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YangihayotParkingRepo extends JpaRepository<YangihayotParking, UUID> {
    Optional<YangihayotParking> findByName(String name);
}
