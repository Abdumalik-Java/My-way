package com.example.webjpahackathon.service.parkingService.parkingRegionService;

import com.example.webjpahackathon.dto.parkingDto.parkingRegionDto.YashnabodParkingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import com.example.webjpahackathon.model.parking.parkingRegion.YashnabodParking;
import com.example.webjpahackathon.repository.parkingRepo.PlacesForDisabledPeopleRepo;
import com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo.YashnabodParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class YashnabodParkingService {

    @Autowired
    YashnabodParkingRepo yashnabodParkingRepo;

    @Autowired
    PlacesForDisabledPeopleRepo placesForDisabledPeopleRepo;

    public List<YashnabodParking> getYashnabodParkings() {
        return yashnabodParkingRepo.findAll();
    }

    public YashnabodParking getYashnabodParking(UUID id) {
        return yashnabodParkingRepo.findById(id).get();
    }

    public YashnabodParking getByName(String name) {
        return yashnabodParkingRepo.findByName(name).get();
    }

    public Result create(YashnabodParkingDto yashnabodParkingDto) {
        YashnabodParking yashnabodParking = new YashnabodParking();
        yashnabodParking.setName(yashnabodParkingDto.getName());
        yashnabodParking.setSize(yashnabodParkingDto.getSize());
        yashnabodParking.setLatitute(yashnabodParkingDto.getLatitute());
        yashnabodParking.setLongtitute(yashnabodParkingDto.getLongtitute());
        yashnabodParking.setPrice(yashnabodParkingDto.getPrice());

        Optional<PlacesForDisabledPeople> byId = placesForDisabledPeopleRepo.findById(yashnabodParkingDto.getPlacesForDisabledPeopleDto());
        PlacesForDisabledPeople placesForDisabledPeople = byId.get();
        yashnabodParking.setPlacesForDisabledPeople(placesForDisabledPeople);

        yashnabodParkingRepo.save(yashnabodParking);
        return new Result("Yashnabod Parking data added successfully", true);
    }

    public Result update(YashnabodParkingDto yashnabodParkingDto, UUID id) {
        Optional<YashnabodParking> byId = yashnabodParkingRepo.findById(id);
        if (byId.isPresent()) {
            YashnabodParking yashnabodParking = byId.get();
            yashnabodParking.setName(yashnabodParkingDto.getName());
            yashnabodParking.setSize(yashnabodParkingDto.getSize());
            yashnabodParking.setLatitute(yashnabodParkingDto.getLatitute());
            yashnabodParking.setLongtitute(yashnabodParkingDto.getLongtitute());
            yashnabodParking.setPrice(yashnabodParkingDto.getPrice());

            Optional<PlacesForDisabledPeople> byId1 = placesForDisabledPeopleRepo.findById(yashnabodParkingDto.getPlacesForDisabledPeopleDto());
            PlacesForDisabledPeople placesForDisabledPeople = byId1.get();
            yashnabodParking.setPlacesForDisabledPeople(placesForDisabledPeople);

            yashnabodParkingRepo.save(yashnabodParking);
            return new Result("Yashnabod Parking data updated successfully", true);
        }
        return new Result("Yashnabod Parking data not found", false);
    }

    public Result delete(UUID id) {
        Optional<YashnabodParking> byId = yashnabodParkingRepo.findById(id);
        if (byId.isPresent()) {
            yashnabodParkingRepo.delete(byId.get());
            return new Result("Yashnabod Parking data deleted successfully", true);
        }
        return new Result("Yashnabod Parking data not found", false);
    }

}