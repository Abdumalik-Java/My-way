package com.example.webjpahackathon.service.parkingService.parkingRegionService;

import com.example.webjpahackathon.dto.parkingDto.parkingRegionDto.YangihayotParkingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import com.example.webjpahackathon.model.parking.parkingRegion.YangihayotParking;
import com.example.webjpahackathon.repository.parkingRepo.PlacesForDisabledPeopleRepo;
import com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo.YangihayotParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class YangihayotParkingService {

    @Autowired
    YangihayotParkingRepo yangihayotParkingRepo;

    @Autowired
    PlacesForDisabledPeopleRepo placesForDisabledPeopleRepo;

    public List<YangihayotParking> getAllYangihayotParking() {
        return yangihayotParkingRepo.findAll();
    }

    public YangihayotParking getYangihayotParkingById(UUID id) {
        return yangihayotParkingRepo.findById(id).get();
    }

    public YangihayotParking getYangihayotParkingByName(String name) {
        return yangihayotParkingRepo.findByName(name).get();
    }

    public Result create(YangihayotParkingDto yangihayotParkingDto) {
        YangihayotParking yangihayotParking = new YangihayotParking();
        yangihayotParking.setName(yangihayotParkingDto.getName());
        yangihayotParking.setSize(yangihayotParkingDto.getSize());
        yangihayotParking.setLatitute(yangihayotParkingDto.getLatitute());
        yangihayotParking.setLongtitute(yangihayotParkingDto.getLongtitute());
        yangihayotParking.setPrice(yangihayotParkingDto.getPrice());

        Optional<PlacesForDisabledPeople> byId = placesForDisabledPeopleRepo.findById(yangihayotParkingDto.getPlacesForDisabledPeopleDto());
        PlacesForDisabledPeople placesForDisabledPeople = byId.get();
        yangihayotParking.setPlacesForDisabledPeople(placesForDisabledPeople);

        yangihayotParkingRepo.save(yangihayotParking);
        return new Result("Yangihayot Parking information created successfully", true);
    }

    public Result update(YangihayotParkingDto yangihayotParkingDto, UUID id) {
        Optional<YangihayotParking> byId = yangihayotParkingRepo.findById(id);
        if (byId.isPresent()) {
            YangihayotParking yangihayotParking = byId.get();
            yangihayotParking.setName(yangihayotParkingDto.getName());
            yangihayotParking.setSize(yangihayotParkingDto.getSize());
            yangihayotParking.setLatitute(yangihayotParkingDto.getLatitute());
            yangihayotParking.setLongtitute(yangihayotParkingDto.getLongtitute());
            yangihayotParking.setPrice(yangihayotParkingDto.getPrice());

            Optional<PlacesForDisabledPeople> byId1 = placesForDisabledPeopleRepo.findById(yangihayotParkingDto.getPlacesForDisabledPeopleDto());
            PlacesForDisabledPeople placesForDisabledPeople1 = byId1.get();
            yangihayotParking.setPlacesForDisabledPeople(placesForDisabledPeople1);

            yangihayotParkingRepo.save(yangihayotParking);
            return new Result("Yangihayot Parking information updated successfully", true);
        }
        return new Result("Yangihayot Parking information not found", false);
    }

    public Result delete(UUID id) {
        Optional<YangihayotParking> byId = yangihayotParkingRepo.findById(id);
        if (byId.isPresent()) {
            yangihayotParkingRepo.delete(byId.get());
            return new Result("Yangihayot Parking information deleted successfully", true);
        }
        return new Result("Yangihayot Parking information not found", false);
    }

}