package com.example.webjpahackathon.service.parkingService;

import com.example.webjpahackathon.dto.parkingDto.PlacesForDisabledPeopleDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import com.example.webjpahackathon.repository.parkingRepo.PlacesForDisabledPeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlacesForDisabledPeopleService {

    @Autowired
    PlacesForDisabledPeopleRepo placesForDisabledPeopleRepo;

    public List<PlacesForDisabledPeople> readAll() {
        return placesForDisabledPeopleRepo.findAll();
    }

    public PlacesForDisabledPeople readById(UUID id) {
        return placesForDisabledPeopleRepo.findById(id).get();
    }

    public PlacesForDisabledPeople readByName(String name) {
        return placesForDisabledPeopleRepo.findByName(name).get();
    }

    public Result create(PlacesForDisabledPeopleDto dto) {
        PlacesForDisabledPeople placesForDisabledPeople = new PlacesForDisabledPeople();
        placesForDisabledPeople.setName(dto.getName());
        placesForDisabledPeople.setLatitute(dto.getLatitute());
        placesForDisabledPeople.setLongtitute(dto.getLongtitute());
        placesForDisabledPeopleRepo.save(placesForDisabledPeople);
        return new Result("Places for disabled people information created successfully", true);
    }

    public Result update(UUID id, PlacesForDisabledPeopleDto dto) {
        Optional<PlacesForDisabledPeople> byId = placesForDisabledPeopleRepo.findById(id);
        if (byId.isPresent()) {
            PlacesForDisabledPeople placesForDisabledPeople = byId.get();
            placesForDisabledPeople.setName(dto.getName());
            placesForDisabledPeople.setLatitute(dto.getLatitute());
            placesForDisabledPeople.setLongtitute(dto.getLongtitute());
            placesForDisabledPeopleRepo.save(placesForDisabledPeople);
            return new Result("Places for disabled people information updated successfully", true);
        }
        return new Result("Places are not found", false);
    }

    public Result delete(UUID id) {
        Optional<PlacesForDisabledPeople> byId = placesForDisabledPeopleRepo.findById(id);
        if (byId.isPresent()) {
            placesForDisabledPeopleRepo.deleteById(id);
            return new Result("Places for disabled people information deleted successfully", true);
        }
        return new Result("Places are not found", false);
    }

}