package com.example.webjpahackathon.repository.regionRepo;

import com.example.webjpahackathon.model.region.Yakkasaroy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface YakkasaroyRepo extends JpaRepository<Yakkasaroy, UUID> {
    Optional<Yakkasaroy> findByName(String name);
}
