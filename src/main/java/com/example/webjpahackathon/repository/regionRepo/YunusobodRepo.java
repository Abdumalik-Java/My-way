package com.example.webjpahackathon.repository.regionRepo;

import com.example.webjpahackathon.model.region.Yunusobod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YunusobodRepo extends JpaRepository<Yunusobod, UUID> {
    Optional<Yunusobod> findByName(String name);
}