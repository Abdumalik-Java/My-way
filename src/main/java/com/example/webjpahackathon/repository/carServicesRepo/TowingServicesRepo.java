package com.example.webjpahackathon.repository.carServicesRepo;

import com.example.webjpahackathon.model.carServices.TowingServices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TowingServicesRepo extends JpaRepository<TowingServices, UUID> {
}
