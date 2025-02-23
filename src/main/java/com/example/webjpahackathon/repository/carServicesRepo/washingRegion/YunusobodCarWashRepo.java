package com.example.webjpahackathon.repository.carServicesRepo.washingRegion;

import com.example.webjpahackathon.model.carServices.washingRegion.YunusobodCarWash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YunusobodCarWashRepo extends JpaRepository<YunusobodCarWash, UUID> {
    Optional<YunusobodCarWash> findByBrandName(String brandName);
}