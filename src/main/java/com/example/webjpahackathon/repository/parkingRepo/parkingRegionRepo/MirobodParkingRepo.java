package com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo;

import com.example.webjpahackathon.model.parking.parkingRegion.MirobodParking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MirobodParkingRepo extends JpaRepository<MirobodParking, UUID> {
    Optional<MirobodParking> findByName(String name);
}
