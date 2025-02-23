package com.example.webjpahackathon.repository.carServicesRepo.detailRepo;

import com.example.webjpahackathon.model.carServices.detail.Mirrors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MirrorsRepo extends JpaRepository<Mirrors, UUID> {
    Optional<Mirrors> findByName(String name);
}
