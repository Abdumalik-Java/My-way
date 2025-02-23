package com.example.webjpahackathon.repository.carServicesRepo.washingRegion;

import com.example.webjpahackathon.model.carServices.washingRegion.YangihayotCarWash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YangihayotCarWashRepo extends JpaRepository<YangihayotCarWash, UUID> {
    Optional<YangihayotCarWash> findByBrandName(String brandName);
}
