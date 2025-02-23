package com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo;

import com.example.webjpahackathon.model.carServices.detailRegion.UchtepaDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UchtepaDetailRepo extends JpaRepository<UchtepaDetail, UUID> {
    Optional<UchtepaDetail> findByStoreName(String storeName);
}
