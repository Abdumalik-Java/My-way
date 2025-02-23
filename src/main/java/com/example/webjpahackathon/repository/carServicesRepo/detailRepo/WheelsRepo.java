package com.example.webjpahackathon.repository.carServicesRepo.detailRepo;

import com.example.webjpahackathon.model.carServices.detail.Wheels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WheelsRepo extends JpaRepository<Wheels, UUID> {
    Optional<Wheels> findByName(String name);
}
