package com.example.webjpahackathon.repository.carServicesRepo.washingRegion;

import com.example.webjpahackathon.model.carServices.washingRegion.BektemirCarWash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BektemirCarWashRepo extends JpaRepository<BektemirCarWash, UUID> {
    Optional<BektemirCarWash> findByBrandName(String brandName);
}