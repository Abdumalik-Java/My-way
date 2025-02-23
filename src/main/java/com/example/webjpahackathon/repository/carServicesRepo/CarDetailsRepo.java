package com.example.webjpahackathon.repository.carServicesRepo;

import com.example.webjpahackathon.model.carServices.CarDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CarDetailsRepo extends JpaRepository<CarDetails, UUID> {
    Optional<CarDetails> findByName(String name);
}
