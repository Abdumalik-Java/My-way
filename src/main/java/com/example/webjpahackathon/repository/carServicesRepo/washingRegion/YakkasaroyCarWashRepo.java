package com.example.webjpahackathon.repository.carServicesRepo.washingRegion;

import com.example.webjpahackathon.model.carServices.washingRegion.YakkasaroyCarWash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YakkasaroyCarWashRepo extends JpaRepository<YakkasaroyCarWash, UUID> {
    Optional<YakkasaroyCarWash> findByBrandName(String brandName);
}
