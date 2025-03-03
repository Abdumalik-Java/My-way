package com.example.webjpahackathon.service.parkingService.parkingRegionService;

import com.example.webjpahackathon.dto.parkingDto.parkingRegionDto.MirobodParkingDto;
import com.example.webjpahackathon.dto.parkingDto.parkingRegionDto.MirzoUlugbekParkingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import com.example.webjpahackathon.model.parking.parkingRegion.MirzoUlugbekParking;
import com.example.webjpahackathon.repository.parkingRepo.PlacesForDisabledPeopleRepo;
import com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo.MirzoUlugbekParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MirzoUlugbekParkingService {

    @Autowired
    MirzoUlugbekParkingRepo mirzoUlugbekParkingRepo;

    @Autowired
    PlacesForDisabledPeopleRepo placesForDisabledPeopleRepo;

    public List<MirzoUlugbekParking> readAllMirzoUlugbekParking() {
        return mirzoUlugbekParkingRepo.findAll();
    }

    public MirzoUlugbekParking readById(UUID id) {
        return mirzoUlugbekParkingRepo.findById(id).get();
    }

    public MirzoUlugbekParking readByName(String name) {
        return mirzoUlugbekParkingRepo.findByName(name).get();
    }

    public Result create(MirzoUlugbekParkingDto parkingDto) {
        MirzoUlugbekParking mirzoUlugbekParking = new MirzoUlugbekParking();
        mirzoUlugbekParking.setName(parkingDto.getName());
        mirzoUlugbekParking.setSize(parkingDto.getSize());
        mirzoUlugbekParking.setLatitute(parkingDto.getLatitute());
        mirzoUlugbekParking.setLongtitute(parkingDto.getLongtitute());
        mirzoUlugbekParking.setPrice(parkingDto.getPrice());

        Optional<PlacesForDisabledPeople> byId = placesForDisabledPeopleRepo.findById(parkingDto.getPlacesForDisabledPeopleDto());
        PlacesForDisabledPeople placesForDisabledPeople = byId.get();
        mirzoUlugbekParking.setPlacesForDisabledPeople(placesForDisabledPeople);

        mirzoUlugbekParkingRepo.save(mirzoUlugbekParking);
        return new Result("Mirzo Ulug`bek parking information created successfully", true);
    }

    public Result update(MirzoUlugbekParkingDto parkingDto, UUID id) {
        Optional<MirzoUlugbekParking> byId = mirzoUlugbekParkingRepo.findById(id);
        if (byId.isPresent()) {
            MirzoUlugbekParking parking = byId.get();
            parking.setName(parkingDto.getName());
            parking.setSize(parkingDto.getSize());
            parking.setLatitute(parkingDto.getLatitute());
            parking.setLongtitute(parkingDto.getLongtitute());
            parking.setPrice(parkingDto.getPrice());

            Optional<PlacesForDisabledPeople> byId1 = placesForDisabledPeopleRepo.findById(parkingDto.getPlacesForDisabledPeopleDto());
            PlacesForDisabledPeople placesForDisabledPeople = byId1.get();
            parking.setPlacesForDisabledPeople(placesForDisabledPeople);

            mirzoUlugbekParkingRepo.save(parking);
            return new Result("Mirzo Ulug`bek parking information updated successfully", true);
        }
        return new Result("Mirzo Ulug`bek parking information not found", false);
    }

    public Result delete(UUID id) {
        Optional<MirzoUlugbekParking> byId = mirzoUlugbekParkingRepo.findById(id);
        if (byId.isPresent()) {
            mirzoUlugbekParkingRepo.delete(byId.get());
            return new Result("Mirzo Ulug`bek parking information deleted successfully", true);
        }
        return new Result("Mirzo Ulug`bek parking not found", false);
    }

}