package com.example.webjpahackathon.repository.regionRepo;

import com.example.webjpahackathon.model.region.Sergeli;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SergeliRepo extends JpaRepository<Sergeli, UUID> {
    Optional<Sergeli> findByName(String name);
}
