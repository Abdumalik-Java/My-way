package com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo;

import com.example.webjpahackathon.model.carServices.detailRegion.YashnabodDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YashnabodDetailRepo extends JpaRepository<YashnabodDetail, UUID> {
    Optional<YashnabodDetail> findByStoreName(String storeName);
}
