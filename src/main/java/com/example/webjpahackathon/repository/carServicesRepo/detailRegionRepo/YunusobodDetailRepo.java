package com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo;

import com.example.webjpahackathon.model.carServices.detailRegion.YunusobodDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YunusobodDetailRepo extends JpaRepository<YunusobodDetail, UUID> {
    Optional<YunusobodDetail> findByStoreName(String storeName);
}
