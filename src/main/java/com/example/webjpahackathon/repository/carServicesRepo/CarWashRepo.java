package com.example.webjpahackathon.repository.carServicesRepo;

import com.example.webjpahackathon.model.carServices.CarWash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CarWashRepo extends JpaRepository<CarWash, UUID> {
    Optional<CarWash> findByBrandName(String name);
}