package com.example.webjpahackathon.repository.carServicesRepo.washingRegion;

import com.example.webjpahackathon.model.carServices.washingRegion.ShayxontohurCarWash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ShayxontohurCarWashRepo extends JpaRepository<ShayxontohurCarWash, UUID> {
    Optional<ShayxontohurCarWash> findByBrandName(String brandName);
}
