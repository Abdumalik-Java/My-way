package com.example.webjpahackathon.repository.regionRepo;

import com.example.webjpahackathon.model.region.MirzoUlugbek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MirzoUlugbekRepo extends JpaRepository<MirzoUlugbek, UUID> {
    Optional<MirzoUlugbek> findByName(String name);
}
