package com.example.webjpahackathon.service.carServicesService.washingRegionService;

import com.example.webjpahackathon.dto.carServicesDto.washingRegionDto.SergeliCarWashingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.washingRegion.SergeliCarWash;
import com.example.webjpahackathon.repository.carServicesRepo.washingRegion.SergeliCarWashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SergeliCarWashService {

    @Autowired
    SergeliCarWashRepo sergeliCarWashRepo;

    public List<SergeliCarWash> getAllSergeliCarWash() {
        return sergeliCarWashRepo.findAll();
    }

    public SergeliCarWash getSergeliCarWashById(UUID id) {
        return sergeliCarWashRepo.findById(id).get();
    }

    public SergeliCarWash getSergeliCarWashByName(String name) {
        return sergeliCarWashRepo.findByBrandName(name).get();
    }

    public Result create(SergeliCarWashingDto sergeliCarWashingDto) {
        SergeliCarWash sergeliCarWash = new SergeliCarWash();
        sergeliCarWash.setBrandName(sergeliCarWashingDto.getBrandName());
        sergeliCarWash.setLatitute(sergeliCarWashingDto.getLatitute());
        sergeliCarWash.setLongtitute(sergeliCarWashingDto.getLongtitute());
        sergeliCarWash.setDescription(sergeliCarWashingDto.getDescription());
        sergeliCarWash.setWashMachine(sergeliCarWashingDto.getWashMachine());
        sergeliCarWash.setHandWash(sergeliCarWashingDto.getHandWash());
        sergeliCarWash.setPrice(sergeliCarWashingDto.getPrice());
        sergeliCarWashRepo.save(sergeliCarWash);
        return new Result("Sergeli car washing information created successfully", true);
    }

    public Result update(UUID id, SergeliCarWashingDto sergeliCarWashingDto) {
        Optional<SergeliCarWash> byId = sergeliCarWashRepo.findById(id);
        if (byId.isPresent()) {
            SergeliCarWash sergeliCarWash = byId.get();
            sergeliCarWash.setBrandName(sergeliCarWashingDto.getBrandName());
            sergeliCarWash.setLatitute(sergeliCarWashingDto.getLatitute());
            sergeliCarWash.setLongtitute(sergeliCarWashingDto.getLongtitute());
            sergeliCarWash.setDescription(sergeliCarWashingDto.getDescription());
            sergeliCarWash.setWashMachine(sergeliCarWashingDto.getWashMachine());
            sergeliCarWash.setHandWash(sergeliCarWashingDto.getHandWash());
            sergeliCarWash.setPrice(sergeliCarWashingDto.getPrice());
            sergeliCarWashRepo.save(sergeliCarWash);
            return new Result("Sergeli car washing updated successfully", true);
        }
        return new Result("Sergeli car washing not found", false);
    }

    public Result delete(UUID id) {
        Optional<SergeliCarWash> byId = sergeliCarWashRepo.findById(id);
        if (byId.isPresent()) {
            sergeliCarWashRepo.deleteById(id);
            return new Result("Sergeli car washing deleted successfully", true);
        }
        return new Result("Sergeli car washing not found", false);
    }

}