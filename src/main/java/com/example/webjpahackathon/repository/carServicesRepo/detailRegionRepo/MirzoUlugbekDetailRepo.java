package com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo;

import com.example.webjpahackathon.model.carServices.detailRegion.MirzoUlugbekDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MirzoUlugbekDetailRepo extends JpaRepository<MirzoUlugbekDetail, UUID> {
    Optional<MirzoUlugbekDetail> findByStoreName(String storeName);
}
