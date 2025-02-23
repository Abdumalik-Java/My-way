package com.example.webjpahackathon.repository.regionRepo;

import com.example.webjpahackathon.model.region.Shayxontohur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ShayxontohurRepo extends JpaRepository<Shayxontohur, UUID> {
    Optional<Shayxontohur> findByName(String name);
}