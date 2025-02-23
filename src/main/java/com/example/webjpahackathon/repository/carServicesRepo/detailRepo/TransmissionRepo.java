package com.example.webjpahackathon.repository.carServicesRepo.detailRepo;

import com.example.webjpahackathon.model.carServices.detail.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TransmissionRepo extends JpaRepository<Transmission, UUID> {
    Optional<Transmission> findByName(String name);
}
