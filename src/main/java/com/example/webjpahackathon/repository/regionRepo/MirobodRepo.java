package com.example.webjpahackathon.repository.regionRepo;

import com.example.webjpahackathon.model.region.Mirobod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MirobodRepo extends JpaRepository<Mirobod, UUID> {
    Optional<Mirobod> findByName(String name);
}
