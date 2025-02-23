package com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo;

import com.example.webjpahackathon.model.carServices.detailRegion.MirobodDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MirobodDetailRepo extends JpaRepository<MirobodDetail, UUID> {
    Optional<MirobodDetail> findByStoreName(String storeName);
}
