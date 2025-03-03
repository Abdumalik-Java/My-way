package com.example.webjpahackathon.service.parkingService.parkingRegionService;

import com.example.webjpahackathon.model.parking.parkingRegion.ChilanzarParking;
import com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo.ChilanzarParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChilanzarParkingService {

    @Autowired
    ChilanzarParkingRepo chilanzarParkingRepo;

    public List<ChilanzarParking> readAll() {
        return chilanzarParkingRepo.findAll();
    }

    public ChilanzarParking readById(UUID id) {
        return chilanzarParkingRepo.findById(id).get();
    }

    public ChilanzarParking readByName(String name) {
        return chilanzarParkingRepo.findByName(name).get();
    }

//

}