package com.example.webjpahackathon.service.parkingService.parkingRegionService;

import com.example.webjpahackathon.dto.parkingDto.parkingRegionDto.OlmazorParkingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import com.example.webjpahackathon.model.parking.parkingRegion.OlmazorParking;
import com.example.webjpahackathon.repository.parkingRepo.PlacesForDisabledPeopleRepo;
import com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo.OlmazorParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OlmazorParkingService {

    @Autowired
    OlmazorParkingRepo olmazorParkingRepo;

    @Autowired
    PlacesForDisabledPeopleRepo placesForDisabledPeopleRepo;

    public List<OlmazorParking> readAllOlmazorParkings() {
        return olmazorParkingRepo.findAll();
    }

    public OlmazorParking readById(UUID id) {
        return olmazorParkingRepo.findById(id).get();
    }

    public OlmazorParking readByName(String name) {
        return olmazorParkingRepo.findByName(name).get();
    }

    public Result create(OlmazorParkingDto olmazorParkingDto) {
        OlmazorParking olmazorParking = new OlmazorParking();
        olmazorParking.setName(olmazorParkingDto.getName());
        olmazorParking.setSize(olmazorParkingDto.getSize());
        olmazorParking.setLatitute(olmazorParkingDto.getLatitute());
        olmazorParking.setLongtitute(olmazorParkingDto.getLongtitute());
        olmazorParking.setPrice(olmazorParkingDto.getPrice());

        Optional<PlacesForDisabledPeople> byId = placesForDisabledPeopleRepo.findById(olmazorParkingDto.getPlacesForDisabledPeopleDto());
        PlacesForDisabledPeople placesForDisabledPeople = byId.get();
        olmazorParking.setPlacesForDisabledPeople(placesForDisabledPeople);

        olmazorParkingRepo.save(olmazorParking);
        return new Result("Olmazor Parking information created successfully", true);
    }

    public Result update(OlmazorParkingDto olmazorParkingDto, UUID id) {
        Optional<OlmazorParking> byId = olmazorParkingRepo.findById(id);
        if (byId.isPresent()) {
            OlmazorParking olmazorParking = byId.get();
            olmazorParking.setName(olmazorParkingDto.getName());
            olmazorParking.setSize(olmazorParkingDto.getSize());
            olmazorParking.setLatitute(olmazorParkingDto.getLatitute());
            olmazorParking.setLongtitute(olmazorParkingDto.getLongtitute());
            olmazorParking.setPrice(olmazorParkingDto.getPrice());

            Optional<PlacesForDisabledPeople> byId1 = placesForDisabledPeopleRepo.findById(olmazorParkingDto.getPlacesForDisabledPeopleDto());
            PlacesForDisabledPeople placesForDisabledPeople = byId1.get();
            olmazorParking.setPlacesForDisabledPeople(placesForDisabledPeople);

            olmazorParkingRepo.save(olmazorParking);
            return new Result("Olmazor Parking information updated successfully", true);
        }
        return new Result("Olmazor Parking information not found", false);
    }

    public Result delete(UUID id) {
        Optional<OlmazorParking> byId = olmazorParkingRepo.findById(id);
        if (byId.isPresent()) {
            olmazorParkingRepo.delete(byId.get());
            return new Result("Olmazor Parking information deleted successfully", true);
        }
        return new Result("Olmazor Parking information not found", false);
    }

}