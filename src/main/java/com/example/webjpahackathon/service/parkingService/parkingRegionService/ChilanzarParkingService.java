package com.example.webjpahackathon.service.parkingService.parkingRegionService;

import com.example.webjpahackathon.dto.parkingDto.parkingRegionDto.ChilanzarParkingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import com.example.webjpahackathon.model.parking.parkingRegion.ChilanzarParking;
import com.example.webjpahackathon.repository.parkingRepo.PlacesForDisabledPeopleRepo;
import com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo.ChilanzarParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChilanzarParkingService {

    @Autowired
    ChilanzarParkingRepo chilanzarParkingRepo;

    @Autowired
    PlacesForDisabledPeopleRepo placesForDisabledPeopleRepo;

    public List<ChilanzarParking> readAll() {
        return chilanzarParkingRepo.findAll();
    }

    public ChilanzarParking readById(UUID id) {
        return chilanzarParkingRepo.findById(id).get();
    }

    public ChilanzarParking readByName(String name) {
        return chilanzarParkingRepo.findByName(name).get();
    }

    public Result create(ChilanzarParkingDto chilanzarParkingDto) {
        ChilanzarParking chilanzarParking = new ChilanzarParking();
        chilanzarParking.setName(chilanzarParkingDto.getName());
        chilanzarParking.setSize(chilanzarParkingDto.getSize());
        chilanzarParking.setLatitute(chilanzarParkingDto.getLatitute());
        chilanzarParking.setLongtitute(chilanzarParkingDto.getLongtitute());
        chilanzarParking.setPrice(chilanzarParkingDto.getPrice());

        Optional<PlacesForDisabledPeople> byId = placesForDisabledPeopleRepo.findById(chilanzarParkingDto.getPlacesForDisabledPeopleDto());
        PlacesForDisabledPeople placesForDisabledPeople = byId.get();
        chilanzarParking.setPlacesForDisabledPeople(placesForDisabledPeople);

        chilanzarParkingRepo.save(chilanzarParking);
        return new Result("Chilanzar parking information created successfully", true);
    }

    public Result update(ChilanzarParkingDto chilanzarParkingDto, UUID id) {
        Optional<ChilanzarParking> byId = chilanzarParkingRepo.findById(id);
        if (byId.isPresent()) {
            ChilanzarParking chilanzarParking = byId.get();
            chilanzarParking.setName(chilanzarParkingDto.getName());
            chilanzarParking.setSize(chilanzarParkingDto.getSize());
            chilanzarParking.setLatitute(chilanzarParkingDto.getLatitute());
            chilanzarParking.setLongtitute(chilanzarParkingDto.getLongtitute());
            chilanzarParking.setPrice(chilanzarParkingDto.getPrice());

            Optional<PlacesForDisabledPeople> byId1 = placesForDisabledPeopleRepo.findById(chilanzarParkingDto.getPlacesForDisabledPeopleDto());
            PlacesForDisabledPeople placesForDisabledPeople = byId1.get();
            chilanzarParking.setPlacesForDisabledPeople(placesForDisabledPeople);

            chilanzarParkingRepo.save(chilanzarParking);
            return new Result("Chilanzar parking information updated successfully", true);
        }
        return new Result("Chilanzar parking information not found", false);
    }

    public Result delete(UUID id) {
        Optional<ChilanzarParking> byId = chilanzarParkingRepo.findById(id);
        if (byId.isPresent()) {
            chilanzarParkingRepo.delete(byId.get());
            return new Result("Chilanzar parking information deleted successfully", true);
        }
        return new Result("Chilanzar parking information not found", false);
    }

}