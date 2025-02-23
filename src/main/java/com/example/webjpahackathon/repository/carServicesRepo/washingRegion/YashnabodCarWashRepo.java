package com.example.webjpahackathon.repository.carServicesRepo.washingRegion;

import com.example.webjpahackathon.model.carServices.washingRegion.YashnabodCarWash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YashnabodCarWashRepo extends JpaRepository<YashnabodCarWash, UUID> {
    Optional<YashnabodCarWash> findByBrandName(String brandName);
}
