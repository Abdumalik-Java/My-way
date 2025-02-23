package com.example.webjpahackathon.repository.carServicesRepo.washingRegion;

import com.example.webjpahackathon.model.carServices.washingRegion.ChilanzarCarWash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ChilanzarCarWashRepo extends JpaRepository<ChilanzarCarWash, UUID> {
    Optional<ChilanzarCarWash> findByBrandName(String brandName);
}
