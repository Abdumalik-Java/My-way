package com.example.webjpahackathon.repository.stationRepo.gasRepo.gasolineAiRepo;

import com.example.webjpahackathon.model.station.gas.gasolineAi.Ai95;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface Ai95Repo extends JpaRepository<Ai95, UUID> {
    Optional<Ai95> findByName(String name);
}
