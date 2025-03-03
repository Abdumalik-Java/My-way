package com.example.webjpahackathon.service.parkingService.parkingRegionService;

import com.example.webjpahackathon.dto.parkingDto.parkingRegionDto.ShayxontohurParkingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import com.example.webjpahackathon.model.parking.parkingRegion.ShayxontohurParking;
import com.example.webjpahackathon.repository.parkingRepo.PlacesForDisabledPeopleRepo;
import com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo.ShayxontohurParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShayxontohurParkingService {

    @Autowired
    ShayxontohurParkingRepo shayxontohurParkingRepo;

    @Autowired
    PlacesForDisabledPeopleRepo placesForDisabledPeopleRepo;

    public List<ShayxontohurParking> getAllShayxontohurParking() {
        return shayxontohurParkingRepo.findAll();
    }

    public ShayxontohurParking getShayxontohurParking(UUID id) {
        return shayxontohurParkingRepo.findById(id).get();
    }

    public ShayxontohurParking getByName(String name) {
        return shayxontohurParkingRepo.findByName(name).get();
    }

    public Result create(ShayxontohurParkingDto shayxontohurParkingDto) {
        ShayxontohurParking shayxontohurParking = new ShayxontohurParking();
        shayxontohurParking.setName(shayxontohurParkingDto.getName());
        shayxontohurParking.setSize(shayxontohurParkingDto.getSize());
        shayxontohurParking.setLatitute(shayxontohurParkingDto.getLatitute());
        shayxontohurParking.setLongtitute(shayxontohurParkingDto.getLongtitute());
        shayxontohurParking.setPrice(shayxontohurParkingDto.getPrice());

        Optional<PlacesForDisabledPeople> byId = placesForDisabledPeopleRepo.findById(shayxontohurParkingDto.getPlacesForDisabledPeopleDto());
        PlacesForDisabledPeople placesForDisabledPeople = byId.get();
        shayxontohurParking.setPlacesForDisabledPeople(placesForDisabledPeople);

        shayxontohurParkingRepo.save(shayxontohurParking);
        return new Result("Shayxontohur Parking information created successfully", true);
    }

    public Result update(UUID id, ShayxontohurParkingDto shayxontohurParkingDto) {
        Optional<ShayxontohurParking> byId = shayxontohurParkingRepo.findById(id);
        if (byId.isPresent()) {
            ShayxontohurParking shayxontohurParking = byId.get();
            shayxontohurParking.setName(shayxontohurParkingDto.getName());
            shayxontohurParking.setSize(shayxontohurParkingDto.getSize());
            shayxontohurParking.setLatitute(shayxontohurParkingDto.getLatitute());
            shayxontohurParking.setLongtitute(shayxontohurParkingDto.getLongtitute());
            shayxontohurParking.setPrice(shayxontohurParkingDto.getPrice());

            Optional<PlacesForDisabledPeople> byId1 = placesForDisabledPeopleRepo.findById(shayxontohurParkingDto.getPlacesForDisabledPeopleDto());
            PlacesForDisabledPeople placesForDisabledPeople = byId1.get();
            shayxontohurParking.setPlacesForDisabledPeople(placesForDisabledPeople);

            shayxontohurParkingRepo.save(shayxontohurParking);
            return new Result("Shayxontohur Parking information updated successfully", true);
        }
        return new Result("Shayxontohur Parking information not found", false);
    }

    public Result delete(UUID id) {
        Optional<ShayxontohurParking> byId = shayxontohurParkingRepo.findById(id);
        if (byId.isPresent()) {
            shayxontohurParkingRepo.delete(byId.get());
            return new Result("Shayxontohur Parking information deleted successfully", true);
        }
        return new Result("Shayxontohur Parking information not found", false);
    }

}