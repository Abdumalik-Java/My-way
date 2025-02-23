package com.example.webjpahackathon.repository.regionRepo;

import com.example.webjpahackathon.model.region.Bektemir;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BektemirRepo extends JpaRepository<Bektemir, UUID> {
    Optional<Bektemir> findByName(String name);
}
