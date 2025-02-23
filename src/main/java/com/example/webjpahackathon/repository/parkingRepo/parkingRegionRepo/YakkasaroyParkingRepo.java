package com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo;

import com.example.webjpahackathon.model.parking.parkingRegion.YakkasaroyParking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YakkasaroyParkingRepo extends JpaRepository<YakkasaroyParking, UUID> {
    Optional<YakkasaroyParking> findByName(String name);
}
