package com.example.webjpahackathon.repository.regionRepo;

import com.example.webjpahackathon.model.region.Yangihayot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface YangihayotRepo extends JpaRepository<Yangihayot, UUID> {
}