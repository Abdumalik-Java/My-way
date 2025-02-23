package com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo;

import com.example.webjpahackathon.model.parking.parkingRegion.OlmazorParking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OlmazorParkingRepo extends JpaRepository<OlmazorParking, UUID> {
    Optional<OlmazorParking> findByName(String name);
}