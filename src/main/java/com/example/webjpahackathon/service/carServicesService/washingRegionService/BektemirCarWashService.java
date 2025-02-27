package com.example.webjpahackathon.service.carServicesService.washingRegionService;

import com.example.webjpahackathon.dto.carServicesDto.washingRegionDto.BektemirCarWashingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.washingRegion.BektemirCarWash;
import com.example.webjpahackathon.repository.carServicesRepo.washingRegion.BektemirCarWashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BektemirCarWashService {

    @Autowired
    BektemirCarWashRepo bektemirCarWashRepo;

    public List<BektemirCarWash> readAllBektemirCarWash() {
        return bektemirCarWashRepo.findAll();
    }

    public BektemirCarWash readBektemirCarWashById(UUID id) {
        return bektemirCarWashRepo.findById(id).get();
    }

    public BektemirCarWash readBektemirCarWashByName(String name) {
        return bektemirCarWashRepo.findByBrandName(name).get();
    }

    public Result create(BektemirCarWashingDto bektemirCarWashingDto) {
        BektemirCarWash bektemirCarWash = new BektemirCarWash();
        bektemirCarWash.setBrandName(bektemirCarWashingDto.getBrandName());
        bektemirCarWash.setLatitute(bektemirCarWashingDto.getLatitute());
        bektemirCarWash.setLongtitute(bektemirCarWashingDto.getLongtitute());
        bektemirCarWash.setDescription(bektemirCarWashingDto.getDescription());
        bektemirCarWash.setWashMachine(bektemirCarWashingDto.getWashMachine());
        bektemirCarWash.setHandWash(bektemirCarWashingDto.getHandWash());
        bektemirCarWash.setPrice(bektemirCarWashingDto.getPrice());
        bektemirCarWashRepo.save(bektemirCarWash);
        return new Result("Bektemir car washing information created successfully", true);
    }

    public Result update(BektemirCarWashingDto bektemirCarWashingDto, UUID id) {
        Optional<BektemirCarWash> byId = bektemirCarWashRepo.findById(id);
        if (byId.isPresent()) {
            BektemirCarWash bektemirCarWash = byId.get();
            bektemirCarWash.setBrandName(bektemirCarWashingDto.getBrandName());
            bektemirCarWash.setLatitute(bektemirCarWashingDto.getLatitute());
            bektemirCarWash.setLongtitute(bektemirCarWashingDto.getLongtitute());
            bektemirCarWash.setDescription(bektemirCarWashingDto.getDescription());
            bektemirCarWash.setWashMachine(bektemirCarWashingDto.getWashMachine());
            bektemirCarWash.setHandWash(bektemirCarWashingDto.getHandWash());
            bektemirCarWash.setPrice(bektemirCarWashingDto.getPrice());
            bektemirCarWashRepo.save(bektemirCarWash);
            return new Result("Bektemir car washing updated successfully", true);
        }
        return new Result("Bektemir car washing not found", false);
    }

    public Result delete(UUID id) {
        Optional<BektemirCarWash> byId = bektemirCarWashRepo.findById(id);
        if (byId.isPresent()) {
            bektemirCarWashRepo.deleteById(id);
            return new Result("Bektemir car washing deleted successfully", true);
        }
        return new Result("Bektemir car washing not found", false);
    }

}