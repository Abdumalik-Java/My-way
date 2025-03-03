package com.example.webjpahackathon.service.parkingService.parkingRegionService;

import com.example.webjpahackathon.dto.parkingDto.parkingRegionDto.YunusobodParkingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import com.example.webjpahackathon.model.parking.parkingRegion.YunusobodParking;
import com.example.webjpahackathon.repository.parkingRepo.PlacesForDisabledPeopleRepo;
import com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo.YunusobodParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class YunusobodParkingService {

    @Autowired
    YunusobodParkingRepo yunusobodParkingRepo;

    @Autowired
    PlacesForDisabledPeopleRepo placesForDisabledPeopleRepo;

    public List<YunusobodParking> getYunusobodParkings() {
        return yunusobodParkingRepo.findAll();
    }

    public YunusobodParking getYunusobodParking(UUID id) {
        return yunusobodParkingRepo.findById(id).get();
    }

    public YunusobodParking getByName(String name) {
        return yunusobodParkingRepo.findByName(name).get();
    }

    public Result create(YunusobodParkingDto dto) {
        YunusobodParking yunusobodParking = new YunusobodParking();
        yunusobodParking.setName(dto.getName());
        yunusobodParking.setSize(dto.getSize());
        yunusobodParking.setLatitute(dto.getLatitute());
        yunusobodParking.setLongtitute(dto.getLongtitute());
        yunusobodParking.setPrice(dto.getPrice());

        Optional<PlacesForDisabledPeople> byId = placesForDisabledPeopleRepo.findById(dto.getPlacesForDisabledPeopleDto());
        PlacesForDisabledPeople placesForDisabledPeople = byId.get();
        yunusobodParking.setPlacesForDisabledPeople(placesForDisabledPeople);

        yunusobodParkingRepo.save(yunusobodParking);
        return new Result("Yangihayot Parking created successfully", true);
    }

    public Result update(YunusobodParkingDto dto, UUID id) {
        Optional<YunusobodParking> byId = yunusobodParkingRepo.findById(id);
        if (byId.isPresent()) {
            YunusobodParking yunusobodParking = byId.get();
            yunusobodParking.setName(dto.getName());
            yunusobodParking.setSize(dto.getSize());
            yunusobodParking.setLatitute(dto.getLatitute());
            yunusobodParking.setLongtitute(dto.getLongtitute());
            yunusobodParking.setPrice(dto.getPrice());

            Optional<PlacesForDisabledPeople> byId1 = placesForDisabledPeopleRepo.findById(dto.getPlacesForDisabledPeopleDto());
            PlacesForDisabledPeople placesForDisabledPeople = byId1.get();
            yunusobodParking.setPlacesForDisabledPeople(placesForDisabledPeople);

            yunusobodParkingRepo.save(yunusobodParking);
            return new Result("Yangihayot Parking updated successfully", true);
        }
        return new Result("Yangihayot Parking not found", false);
    }

    public Result delete(UUID id) {
        Optional<YunusobodParking> byId = yunusobodParkingRepo.findById(id);
        if (byId.isPresent()) {
            yunusobodParkingRepo.delete(byId.get());
            return new Result("Yangihayot Parking deleted successfully", true);
        }
        return new Result("Yangihayot Parking not found", false);
    }

}