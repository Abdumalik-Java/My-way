package com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo;

import com.example.webjpahackathon.model.carServices.detailRegion.YangihayotDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YangihayotDetailRepo extends JpaRepository<YangihayotDetail, UUID> {
    Optional<YangihayotDetail> findByStoreName(String storeName);
}
