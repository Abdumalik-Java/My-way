package com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo;

import com.example.webjpahackathon.model.parking.parkingRegion.YunusobodParking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YunusobodParkingRepo extends JpaRepository<YunusobodParking, UUID> {
    Optional<YunusobodParking> findByName(String name);
}