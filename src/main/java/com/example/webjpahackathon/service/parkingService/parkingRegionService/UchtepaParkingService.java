package com.example.webjpahackathon.service.parkingService.parkingRegionService;

import com.example.webjpahackathon.dto.parkingDto.parkingRegionDto.UchtepaParkingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import com.example.webjpahackathon.model.parking.parkingRegion.UchtepaParking;
import com.example.webjpahackathon.repository.parkingRepo.PlacesForDisabledPeopleRepo;
import com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo.UchtepaParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UchtepaParkingService {

    @Autowired
    UchtepaParkingRepo uchtepaParkingRepo;

    @Autowired
    PlacesForDisabledPeopleRepo placesForDisabledPeopleRepo;

    public List<UchtepaParking> getAllUchtepaParkings() {
        return uchtepaParkingRepo.findAll();
    }

    public UchtepaParking getUchtepaParking(UUID id) {
        return uchtepaParkingRepo.findById(id).get();
    }

    public UchtepaParking getByName(String name) {
        return uchtepaParkingRepo.findByName(name).get();
    }

    public Result createUchtepaParking(UchtepaParkingDto uchtepaParkingDto) {
        UchtepaParking uchtepaParking = new UchtepaParking();
        uchtepaParking.setName(uchtepaParkingDto.getName());
        uchtepaParking.setSize(uchtepaParkingDto.getSize());
        uchtepaParking.setLatitute(uchtepaParkingDto.getLatitute());
        uchtepaParking.setLongtitute(uchtepaParkingDto.getLongtitute());
        uchtepaParking.setPrice(uchtepaParkingDto.getPrice());

        Optional<PlacesForDisabledPeople> byId = placesForDisabledPeopleRepo.findById(uchtepaParkingDto.getPlacesForDisabledPeopleDto());
        PlacesForDisabledPeople placesForDisabledPeople = byId.get();
        uchtepaParking.setPlacesForDisabledPeople(placesForDisabledPeople);

        uchtepaParkingRepo.save(uchtepaParking);
        return new Result("Uchtepa Parking created successfully", true);
    }

    public Result update(UUID id, UchtepaParkingDto uchtepaParkingDto) {
        Optional<UchtepaParking> byId = uchtepaParkingRepo.findById(id);
        if (byId.isPresent()) {
            UchtepaParking uchtepaParking = byId.get();
            uchtepaParking.setName(uchtepaParkingDto.getName());
            uchtepaParking.setSize(uchtepaParkingDto.getSize());
            uchtepaParking.setLatitute(uchtepaParkingDto.getLatitute());
            uchtepaParking.setLongtitute(uchtepaParkingDto.getLongtitute());
            uchtepaParking.setPrice(uchtepaParkingDto.getPrice());

            Optional<PlacesForDisabledPeople> byId1 = placesForDisabledPeopleRepo.findById(uchtepaParkingDto.getPlacesForDisabledPeopleDto());
            PlacesForDisabledPeople placesForDisabledPeople1 = byId1.get();
            uchtepaParking.setPlacesForDisabledPeople(placesForDisabledPeople1);

            uchtepaParkingRepo.save(uchtepaParking);
            return new Result("Uchtepa Parking updated successfully", true);
        }
        return new Result("Uchtepa Parking not found", false);
    }

    public Result deleteUchtepaParking(UUID id) {
        Optional<UchtepaParking> byId = uchtepaParkingRepo.findById(id);
        if (byId.isPresent()) {
            uchtepaParkingRepo.delete(byId.get());
            return new Result("Uchtepa Parking deleted successfully", true);
        }
        return new Result("Uchtepa Parking not found", false);
    }

}