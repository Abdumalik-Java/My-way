package com.example.webjpahackathon.repository.carServicesRepo.washingRegion;

import com.example.webjpahackathon.model.carServices.washingRegion.OlmazorCarWash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OlmazorCarWashRepo extends JpaRepository<OlmazorCarWash, UUID> {
    Optional<OlmazorCarWash> findByBrandName(String brandName);
}
