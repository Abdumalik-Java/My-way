package com.example.webjpahackathon.repository.stationRepo.gasRepo.gasolineAiRepo;

import com.example.webjpahackathon.model.station.gas.gasolineAi.Ai92;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface Ai92Repo extends JpaRepository<Ai92, UUID> {
    Optional<Ai92> findByName(String name);
}
