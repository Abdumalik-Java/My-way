package com.example.webjpahackathon.service.carServicesService.washingRegionService;

import com.example.webjpahackathon.dto.carServicesDto.washingRegionDto.UchtepaCarWashingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.washingRegion.UchtepaCarWash;
import com.example.webjpahackathon.repository.carServicesRepo.washingRegion.UchtepaCarWashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UchtepaCarWashService {

    @Autowired
    UchtepaCarWashRepo uchtepaCarWashRepo;

    public List<UchtepaCarWash> readAll() {
        return uchtepaCarWashRepo.findAll();
    }

    public UchtepaCarWash readById(UUID id) {
        return uchtepaCarWashRepo.findById(id).get();
    }

    public UchtepaCarWash readByName(String name) {
        return uchtepaCarWashRepo.findByBrandName(name).get();
    }

    public Result create(UchtepaCarWashingDto uchtepaCarWashingDto) {
        UchtepaCarWash uchtepaCarWash = new UchtepaCarWash();
        uchtepaCarWash.setBrandName(uchtepaCarWashingDto.getBrandName());
        uchtepaCarWash.setLatitute(uchtepaCarWashingDto.getLatitute());
        uchtepaCarWash.setLongtitute(uchtepaCarWashingDto.getLongtitute());
        uchtepaCarWash.setDescription(uchtepaCarWashingDto.getDescription());
        uchtepaCarWash.setWashMachine(uchtepaCarWashingDto.getWashMachine());
        uchtepaCarWash.setHandWash(uchtepaCarWashingDto.getHandWash());
        uchtepaCarWash.setPrice(uchtepaCarWashingDto.getPrice());
        uchtepaCarWashRepo.save(uchtepaCarWash);
        return new Result("Uchtepa car wash information created successfully", true);
    }

    public Result update(UUID id, UchtepaCarWashingDto uchtepaCarWashingDto) {
        Optional<UchtepaCarWash> byId = uchtepaCarWashRepo.findById(id);
        if (byId.isPresent()) {
            UchtepaCarWash uchtepaCarWash = byId.get();
            uchtepaCarWash.setBrandName(uchtepaCarWashingDto.getBrandName());
            uchtepaCarWash.setLatitute(uchtepaCarWashingDto.getLatitute());
            uchtepaCarWash.setLongtitute(uchtepaCarWashingDto.getLongtitute());
            uchtepaCarWash.setDescription(uchtepaCarWashingDto.getDescription());
            uchtepaCarWash.setWashMachine(uchtepaCarWashingDto.getWashMachine());
            uchtepaCarWash.setHandWash(uchtepaCarWashingDto.getHandWash());
            uchtepaCarWash.setPrice(uchtepaCarWashingDto.getPrice());
            uchtepaCarWashRepo.save(uchtepaCarWash);
            return new Result("Uchtepa car wash information created successfully", true);
        }
        return new Result("Uchtepa car wash information not found", false);
    }

    public Result delete(UUID id) {
        Optional<UchtepaCarWash> byId = uchtepaCarWashRepo.findById(id);
        if (byId.isPresent()) {
            uchtepaCarWashRepo.deleteById(id);
            return new Result("Uchtepa car wash information deleted successfully", true);
        }
        return new Result("Uchtepa car wash information not found", false);
    }

}