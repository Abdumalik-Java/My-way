package com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo;

import com.example.webjpahackathon.model.carServices.detailRegion.OlmazorDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OlmazorDetailRepo extends JpaRepository<OlmazorDetail, UUID> {
    Optional<OlmazorDetail> findByStoreName(String storeName);
}
