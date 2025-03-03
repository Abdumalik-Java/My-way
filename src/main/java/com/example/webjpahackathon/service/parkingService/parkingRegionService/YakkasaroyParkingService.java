package com.example.webjpahackathon.service.parkingService.parkingRegionService;

import com.example.webjpahackathon.dto.parkingDto.parkingRegionDto.YakkasaroyParkingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import com.example.webjpahackathon.model.parking.parkingRegion.YakkasaroyParking;
import com.example.webjpahackathon.repository.parkingRepo.PlacesForDisabledPeopleRepo;
import com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo.YakkasaroyParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class YakkasaroyParkingService {

    @Autowired
    YakkasaroyParkingRepo yakkasaroyParkingRepo;

    @Autowired
    PlacesForDisabledPeopleRepo placesForDisabledPeopleRepo;

    public List<YakkasaroyParking> getAllParkings() {
        return yakkasaroyParkingRepo.findAll();
    }

    public YakkasaroyParking getParking(UUID id) {
        return yakkasaroyParkingRepo.findById(id).get();
    }

    public YakkasaroyParking getByName(String name) {
        return yakkasaroyParkingRepo.findByName(name).get();
    }

    public Result create(YakkasaroyParkingDto yakkasaroyParkingDto) {
        YakkasaroyParking yakkasaroyParking = new YakkasaroyParking();
        yakkasaroyParking.setName(yakkasaroyParkingDto.getName());
        yakkasaroyParking.setSize(yakkasaroyParkingDto.getSize());
        yakkasaroyParking.setLatitute(yakkasaroyParkingDto.getLatitute());
        yakkasaroyParking.setLongtitute(yakkasaroyParkingDto.getLongtitute());
        yakkasaroyParking.setPrice(yakkasaroyParkingDto.getPrice());

        Optional<PlacesForDisabledPeople> byId = placesForDisabledPeopleRepo.findById(yakkasaroyParkingDto.getPlacesForDisabledPeopleDto());
        PlacesForDisabledPeople placesForDisabledPeople = byId.get();
        yakkasaroyParking.setPlacesForDisabledPeople(placesForDisabledPeople);

        yakkasaroyParkingRepo.save(yakkasaroyParking);
        return new Result("Yakkasaroy Parking was successfully created", true);
    }

    public Result update(UUID id, YakkasaroyParkingDto dto) {
        Optional<YakkasaroyParking> byId = yakkasaroyParkingRepo.findById(id);
        if (byId.isPresent()) {
            YakkasaroyParking yakkasaroyParking = byId.get();
            yakkasaroyParking.setName(dto.getName());
            yakkasaroyParking.setSize(dto.getSize());
            yakkasaroyParking.setLatitute(dto.getLatitute());
            yakkasaroyParking.setLongtitute(dto.getLongtitute());
            yakkasaroyParking.setPrice(dto.getPrice());

            Optional<PlacesForDisabledPeople> byId1 = placesForDisabledPeopleRepo.findById(dto.getPlacesForDisabledPeopleDto());
            PlacesForDisabledPeople placesForDisabledPeople = byId1.get();
            yakkasaroyParking.setPlacesForDisabledPeople(placesForDisabledPeople);

            yakkasaroyParkingRepo.save(yakkasaroyParking);
            return new Result("Yakkasaroy Parking was successfully updated", true);
        }
        return new Result("Yakkasaroy Parking not found", false);
    }

    public Result delete(UUID id) {
        Optional<YakkasaroyParking> byId = yakkasaroyParkingRepo.findById(id);
        if (byId.isPresent()) {
            yakkasaroyParkingRepo.delete(byId.get());
            return new Result("Yakkasaroy Parking was successfully deleted", true);
        }
        return new Result("Yakkasaroy Parking not found", false);
    }

}