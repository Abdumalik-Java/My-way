package com.example.webjpahackathon.repository.regionRepo;

import com.example.webjpahackathon.model.region.Olmazor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OlmazorRepo extends JpaRepository<Olmazor, UUID> {
    Optional<Olmazor> findByName(String name);
}
