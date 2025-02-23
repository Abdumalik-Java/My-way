package com.example.webjpahackathon.repository.regionRepo;

import com.example.webjpahackathon.model.region.Uchtepa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UchtepaRepo extends JpaRepository<Uchtepa, UUID> {
    Optional<Uchtepa> findByName(String name);
}