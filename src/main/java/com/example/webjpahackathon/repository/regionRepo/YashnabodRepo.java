package com.example.webjpahackathon.repository.regionRepo;

import com.example.webjpahackathon.model.region.Yashnabod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YashnabodRepo extends JpaRepository<Yashnabod, UUID> {
    Optional<Yashnabod> findByName(String name);
}
