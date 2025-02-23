package com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo;

import com.example.webjpahackathon.model.carServices.detailRegion.ChilanzarDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ChilanzarDetailRepo extends JpaRepository<ChilanzarDetail, UUID> {
    Optional<ChilanzarDetail> findByStoreName(String storeName);
}
