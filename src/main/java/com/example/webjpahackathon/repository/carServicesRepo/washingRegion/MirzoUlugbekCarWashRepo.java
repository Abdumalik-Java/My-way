package com.example.webjpahackathon.repository.carServicesRepo.washingRegion;

import com.example.webjpahackathon.model.carServices.washingRegion.MirzoUlugbekCarWash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MirzoUlugbekCarWashRepo extends JpaRepository<MirzoUlugbekCarWash, UUID> {
    Optional<MirzoUlugbekCarWash> findByBrandName(String brandName);
}
