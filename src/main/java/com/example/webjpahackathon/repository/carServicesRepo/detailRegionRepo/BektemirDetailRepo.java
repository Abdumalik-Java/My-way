package com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo;

import com.example.webjpahackathon.model.carServices.detailRegion.BektemirDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BektemirDetailRepo extends JpaRepository<BektemirDetail, UUID> {
    Optional<BektemirDetail> findByStoreName(String storeName);
}
