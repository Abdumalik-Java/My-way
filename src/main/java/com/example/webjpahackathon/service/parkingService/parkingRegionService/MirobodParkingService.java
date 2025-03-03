package com.example.webjpahackathon.service.parkingService.parkingRegionService;

import com.example.webjpahackathon.dto.parkingDto.parkingRegionDto.MirobodParkingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import com.example.webjpahackathon.model.parking.parkingRegion.MirobodParking;
import com.example.webjpahackathon.repository.parkingRepo.PlacesForDisabledPeopleRepo;
import com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo.MirobodParkingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MirobodParkingService {

    @Autowired
    MirobodParkingRepo mirobodParkingRepo;

    @Autowired
    PlacesForDisabledPeopleRepo placesForDisabledPeopleRepo;

    public List<MirobodParking> getMirobodParkings() {
        return mirobodParkingRepo.findAll();
    }

    public MirobodParking getMirobodParking(UUID id) {
        return mirobodParkingRepo.findById(id).get();
    }

    public MirobodParking getByName(String name) {
        return mirobodParkingRepo.findByName(name).get();
    }

    public Result create(MirobodParkingDto mirobodParkingDto) {
        MirobodParking mirobodParking = new MirobodParking();
        mirobodParking.setName(mirobodParkingDto.getName());
        mirobodParking.setSize(mirobodParkingDto.getSize());
        mirobodParking.setLatitute(mirobodParkingDto.getLatitute());
        mirobodParking.setLongtitute(mirobodParkingDto.getLongtitute());
        mirobodParking.setPrice(mirobodParkingDto.getPrice());

        Optional<PlacesForDisabledPeople> byId = placesForDisabledPeopleRepo.findById(mirobodParkingDto.getPlacesForDisabledPeopleDto());
        PlacesForDisabledPeople placesForDisabledPeople = byId.get();
        mirobodParking.setPlacesForDisabledPeople(placesForDisabledPeople);

        mirobodParkingRepo.save(mirobodParking);
        return new Result("Mirobod Parking information created successfully", true);
    }

    public Result update(MirobodParkingDto mirobodParkingDto, UUID id) {
        Optional<MirobodParking> byId = mirobodParkingRepo.findById(id);
        if (byId.isPresent()) {
            MirobodParking mirobodParking = byId.get();
            mirobodParking.setName(mirobodParkingDto.getName());
            mirobodParking.setSize(mirobodParkingDto.getSize());
            mirobodParking.setLatitute(mirobodParkingDto.getLatitute());
            mirobodParking.setLongtitute(mirobodParkingDto.getLongtitute());
            mirobodParking.setPrice(mirobodParkingDto.getPrice());

            Optional<PlacesForDisabledPeople> byId1 = placesForDisabledPeopleRepo.findById(mirobodParkingDto.getPlacesForDisabledPeopleDto());
            PlacesForDisabledPeople placesForDisabledPeople1 = byId1.get();
            mirobodParking.setPlacesForDisabledPeople(placesForDisabledPeople1);

            mirobodParkingRepo.save(mirobodParking);
            return new Result("Mirobod Parking information updated successfully", true);
        }
        return new Result("Mirobod Parking information not found", false);
    }

    public Result delete(UUID id) {
        Optional<MirobodParking> byId = mirobodParkingRepo.findById(id);
        if (byId.isPresent()) {
            mirobodParkingRepo.delete(byId.get());
            return new Result("Mirobod Parking information deleted successfully", true);
        }
        return new Result("Mirobod Parking information not found", false);
    }

}