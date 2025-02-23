package com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo;

import com.example.webjpahackathon.model.carServices.detailRegion.SergeliDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SergeliDetailRepo extends JpaRepository<SergeliDetail, UUID> {
    Optional<SergeliDetail> findByStoreName(String storeName);
}
