package com.example.webjpahackathon.service.parkingService.parkingRegionService;

import com.example.webjpahackathon.dto.parkingDto.parkingRegionDto.SergeliParkingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import com.example.webjpahackathon.model.parking.parkingRegion.SergeliParking;
import com.example.webjpahackathon.repository.parkingRepo.PlacesForDisabledPeopleRepo;
import com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo.SergeliParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SergeliParkingService {

    @Autowired
    SergeliParkingRepo sergeliParkingRepo;

    @Autowired
    PlacesForDisabledPeopleRepo placesForDisabledPeopleRepo;

    public List<SergeliParking> getAllSergeliParkings() {
        return sergeliParkingRepo.findAll();
    }

    public SergeliParking getSergeliParkingById(UUID id) {
        return sergeliParkingRepo.findById(id).get();
    }

    public SergeliParking getSergeliParkingByName(String name) {
        return sergeliParkingRepo.findByName(name).get();
    }

    public Result createSergeliParking(SergeliParkingDto sergeliParkingDto) {
        SergeliParking sergeliParking = new SergeliParking();
        sergeliParking.setName(sergeliParkingDto.getName());
        sergeliParking.setSize(sergeliParkingDto.getSize());
        sergeliParking.setLatitute(sergeliParkingDto.getLatitute());
        sergeliParking.setLongtitute(sergeliParkingDto.getLongtitute());
        sergeliParking.setPrice(sergeliParkingDto.getPrice());

        Optional<PlacesForDisabledPeople> places = placesForDisabledPeopleRepo.findById(sergeliParkingDto.getPlacesForDisabledPeopleDto());
        PlacesForDisabledPeople placesForDisabledPeople = places.get();
        sergeliParking.setPlacesForDisabledPeople(placesForDisabledPeople);

        sergeliParkingRepo.save(sergeliParking);
        return new Result("Sergeli Parking created successfully", true);
    }

    public Result update(UUID id, SergeliParkingDto sergeliParkingDto) {
        Optional<SergeliParking> byId = sergeliParkingRepo.findById(id);
        if (byId.isPresent()) {
            SergeliParking sergeliParking = byId.get();
            sergeliParking.setName(sergeliParkingDto.getName());
            sergeliParking.setSize(sergeliParkingDto.getSize());
            sergeliParking.setLatitute(sergeliParkingDto.getLatitute());
            sergeliParking.setLongtitute(sergeliParkingDto.getLongtitute());
            sergeliParking.setPrice(sergeliParkingDto.getPrice());

            Optional<PlacesForDisabledPeople> byId1 = placesForDisabledPeopleRepo.findById(sergeliParkingDto.getPlacesForDisabledPeopleDto());
            PlacesForDisabledPeople placesForDisabledPeople1 = byId1.get();
            sergeliParking.setPlacesForDisabledPeople(placesForDisabledPeople1);

            sergeliParkingRepo.save(sergeliParking);
            return new Result("Sergeli Parking updated successfully", true);
        }
        return new Result("Sergeli Parking not found", false);
    }

    public Result delete(UUID id) {
        Optional<SergeliParking> byId = sergeliParkingRepo.findById(id);
        if (byId.isPresent()) {
            sergeliParkingRepo.delete(byId.get());
            return new Result("Sergeli Parking deleted successfully", true);
        }
        return new Result("Sergeli Parking not found", false);
    }

}