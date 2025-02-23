package com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo;

import com.example.webjpahackathon.model.carServices.detailRegion.YakkasaroyDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YakkasaroyDetailRepo extends JpaRepository<YakkasaroyDetail, UUID> {
    Optional<YakkasaroyDetail> findByStoreName(String storeName);
}
