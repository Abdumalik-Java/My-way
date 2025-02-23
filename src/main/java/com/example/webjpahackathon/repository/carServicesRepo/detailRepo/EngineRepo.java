package com.example.webjpahackathon.repository.carServicesRepo.detailRepo;

import com.example.webjpahackathon.model.carServices.detail.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EngineRepo extends JpaRepository<Engine, UUID> {
    Optional<Engine> findByName(String name);
}