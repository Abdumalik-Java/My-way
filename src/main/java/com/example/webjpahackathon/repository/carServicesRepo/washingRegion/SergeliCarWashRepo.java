package com.example.webjpahackathon.repository.carServicesRepo.washingRegion;

import com.example.webjpahackathon.model.carServices.washingRegion.SergeliCarWash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SergeliCarWashRepo extends JpaRepository<SergeliCarWash, UUID> {
    Optional<SergeliCarWash> findByBrandName(String brandName);
}
