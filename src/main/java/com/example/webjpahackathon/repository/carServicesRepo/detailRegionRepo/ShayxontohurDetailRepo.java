package com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo;

import com.example.webjpahackathon.model.carServices.detailRegion.ShayxontohurDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ShayxontohurDetailRepo extends JpaRepository<ShayxontohurDetail, UUID> {
    Optional<ShayxontohurDetail> findByStoreName(String storeName);
}
