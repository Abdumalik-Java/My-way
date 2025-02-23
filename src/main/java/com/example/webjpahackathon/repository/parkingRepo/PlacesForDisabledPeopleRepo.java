package com.example.webjpahackathon.repository.parkingRepo;

import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlacesForDisabledPeopleRepo extends JpaRepository<PlacesForDisabledPeople, UUID> {
    Optional<PlacesForDisabledPeople> findByName(String name);
}