package com.example.webjpahackathon.repository.parkingRepo;

import com.example.webjpahackathon.model.parking.ParkingPlaces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ParkingPlacesRepo extends JpaRepository<ParkingPlaces, UUID> {
    Optional<ParkingPlaces> findByName(String name);
}