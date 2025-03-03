package com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo;

import com.example.webjpahackathon.model.parking.parkingRegion.ShayxontohurParking;
import com.example.webjpahackathon.model.region.Shayxontohur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ShayxontohurParkingRepo extends JpaRepository<ShayxontohurParking, UUID> {
    Optional<ShayxontohurParking> findByName(String name);
}