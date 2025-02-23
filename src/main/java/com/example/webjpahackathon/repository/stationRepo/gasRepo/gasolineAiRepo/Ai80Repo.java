package com.example.webjpahackathon.repository.stationRepo.gasRepo.gasolineAiRepo;

import com.example.webjpahackathon.model.station.gas.gasolineAi.Ai80;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface Ai80Repo extends JpaRepository<Ai80, UUID> {
    Optional<Ai80> findByName(String name);
}
