package com.example.webjpahackathon.service.parkingService.parkingRegionService;

import com.example.webjpahackathon.dto.parkingDto.parkingRegionDto.BektemirParkingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import com.example.webjpahackathon.model.parking.parkingRegion.BektemirParking;
import com.example.webjpahackathon.repository.parkingRepo.PlacesForDisabledPeopleRepo;
import com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo.BektemirParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BektemirParkingService {

    @Autowired
    BektemirParkingRepo bektemirParkingRepo;

    @Autowired
    PlacesForDisabledPeopleRepo placesForDisabledPeopleRepo;

    public List<BektemirParking> readAll() {
        return bektemirParkingRepo.findAll();
    }

    public BektemirParking readById(UUID id) {
        return bektemirParkingRepo.findById(id).get();
    }

    public BektemirParking readByName(String name) {
        return bektemirParkingRepo.findByName(name).get();
    }

    public Result create(BektemirParkingDto bektemirParkingDto) {
        BektemirParking bektemirParking = new BektemirParking();
        bektemirParking.setName(bektemirParkingDto.getName());
        bektemirParking.setSize(bektemirParkingDto.getSize());
        bektemirParking.setLatitute(bektemirParkingDto.getLatitute());
        bektemirParking.setLongtitute(bektemirParkingDto.getLongtitute());
        bektemirParking.setPrice(bektemirParkingDto.getPrice());

        Optional<PlacesForDisabledPeople> byId = placesForDisabledPeopleRepo.findById(bektemirParkingDto.getPlacesForDisabledPeopleDto());
        PlacesForDisabledPeople placesForDisabledPeople = byId.get();
        bektemirParking.setPlacesForDisabledPeople(placesForDisabledPeople);

        bektemirParkingRepo.save(bektemirParking);
        return new Result("Bektemir parking information created successfully", true);
    }

    public Result update(UUID id, BektemirParkingDto bektemirParkingDto) {
        Optional<BektemirParking> byId = bektemirParkingRepo.findById(id);
        if (byId.isPresent()) {
            BektemirParking bektemirParking = byId.get();
            bektemirParking.setName(bektemirParkingDto.getName());
            bektemirParking.setSize(bektemirParkingDto.getSize());
            bektemirParking.setLatitute(bektemirParkingDto.getLatitute());
            bektemirParking.setLongtitute(bektemirParkingDto.getLongtitute());
            bektemirParking.setPrice(bektemirParkingDto.getPrice());

            Optional<PlacesForDisabledPeople> byIdorg = placesForDisabledPeopleRepo.findById(bektemirParkingDto.getPlacesForDisabledPeopleDto());
            PlacesForDisabledPeople placesForDisabledPeople = byIdorg.get();
            bektemirParking.setPlacesForDisabledPeople(placesForDisabledPeople);
            bektemirParkingRepo.save(bektemirParking);
            return new Result("Bektemir parking information updated successfully", true);
        }
        return new Result("Bektemir parking information not found", false);
    }

    public Result delete(UUID id) {
        Optional<BektemirParking> byId = bektemirParkingRepo.findById(id);
        if (byId.isPresent()) {
            bektemirParkingRepo.deleteById(id);
            return new Result("Bektemir parking information deleted successfully", true);
        }
        return new Result("Information not found", false);
    }

}