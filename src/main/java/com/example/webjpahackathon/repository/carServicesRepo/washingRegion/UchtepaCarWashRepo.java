package com.example.webjpahackathon.repository.carServicesRepo.washingRegion;

import com.example.webjpahackathon.model.carServices.washingRegion.UchtepaCarWash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UchtepaCarWashRepo extends JpaRepository<UchtepaCarWash, UUID> {
    Optional<UchtepaCarWash> findByBrandName(String brandName);
}
