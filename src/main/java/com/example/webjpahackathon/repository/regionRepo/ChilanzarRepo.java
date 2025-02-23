package com.example.webjpahackathon.repository.regionRepo;

import com.example.webjpahackathon.model.region.Chilanzar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ChilanzarRepo extends JpaRepository<Chilanzar, UUID> {
    Optional<Chilanzar> findByName(String name);
}
