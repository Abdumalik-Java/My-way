package com.example.webjpahackathon.repository;

import com.example.webjpahackathon.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CarRepo extends JpaRepository<Car, UUID> {
    Optional<Car> findByName(String name);
}
