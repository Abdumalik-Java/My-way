package com.example.webjpahackathon.repository.carServicesRepo.detailRepo;

import com.example.webjpahackathon.model.carServices.detail.Seats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SeatsRepo extends JpaRepository<Seats, UUID> {
    Optional<Seats> findByName(String name);
}
