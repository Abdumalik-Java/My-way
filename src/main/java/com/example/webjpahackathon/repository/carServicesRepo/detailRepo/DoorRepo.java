package com.example.webjpahackathon.repository.carServicesRepo.detailRepo;

import com.example.webjpahackathon.model.carServices.detail.Door;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DoorRepo extends JpaRepository<Door, UUID> {
    Optional<Door> findByName(String name);
}
