package com.example.webjpahackathon.repository.stationRepo.gasRepo.gasolineAiRepo;

import com.example.webjpahackathon.model.station.gas.gasolineAi.Ai100;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface Ai100Repo extends JpaRepository<Ai100, UUID> {
    Optional<Ai100> findByName(String name);
}
