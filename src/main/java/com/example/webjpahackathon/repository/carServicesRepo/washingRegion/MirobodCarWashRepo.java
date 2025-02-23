package com.example.webjpahackathon.repository.carServicesRepo.washingRegion;

import com.example.webjpahackathon.model.carServices.washingRegion.MirobodCarWash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MirobodCarWashRepo extends JpaRepository<MirobodCarWash, UUID> {
    Optional<MirobodCarWash> findByBrandName(String brandName);
}
