package com.example.webjpahackathon.repository.carServicesRepo.detailRepo;

import com.example.webjpahackathon.model.carServices.detail.Tires;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TiresRepo extends JpaRepository<Tires, UUID> {
    Optional<Tires> findByName(String name);
}
