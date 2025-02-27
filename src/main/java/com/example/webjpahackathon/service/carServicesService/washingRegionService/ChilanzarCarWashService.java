package com.example.webjpahackathon.service.carServicesService.washingRegionService;

import com.example.webjpahackathon.dto.carServicesDto.washingRegionDto.ChilanzarCarWashingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.washingRegion.ChilanzarCarWash;
import com.example.webjpahackathon.repository.carServicesRepo.washingRegion.ChilanzarCarWashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChilanzarCarWashService {

    @Autowired
    ChilanzarCarWashRepo chilanzarCarWashRepo;

    public List<ChilanzarCarWash> getChilanzarCarWash() {
        return chilanzarCarWashRepo.findAll();
    }

    public ChilanzarCarWash getChilanzarCarWash(UUID id) {
        return chilanzarCarWashRepo.findById(id).get();
    }

    public ChilanzarCarWash getByName(String name) {
        return chilanzarCarWashRepo.findByBrandName(name).get();
    }

    public Result create(ChilanzarCarWashingDto chilanzarCarWashingDto) {
        ChilanzarCarWash chilanzarCarWash = new ChilanzarCarWash();
        chilanzarCarWash.setBrandName(chilanzarCarWashingDto.getBrandName());
        chilanzarCarWash.setLatitute(chilanzarCarWashingDto.getLatitute());
        chilanzarCarWash.setLongtitute(chilanzarCarWashingDto.getLongtitute());
        chilanzarCarWash.setDescription(chilanzarCarWashingDto.getDescription());
        chilanzarCarWash.setWashMachine(chilanzarCarWashingDto.getWashMachine());
        chilanzarCarWash.setHandWash(chilanzarCarWashingDto.getHandWash());
        chilanzarCarWash.setPrice(chilanzarCarWashingDto.getPrice());
        chilanzarCarWashRepo.save(chilanzarCarWash);
        return new Result("Chilanzar Car Wash Created successfully", true);
    }

    public Result update(UUID id,ChilanzarCarWashingDto chilanzarCarWashingDto) {
        Optional<ChilanzarCarWash> byId = chilanzarCarWashRepo.findById(id);
        if (byId.isPresent()) {
            ChilanzarCarWash chilanzarCarWash = byId.get();
            chilanzarCarWash.setBrandName(chilanzarCarWashingDto.getBrandName());
            chilanzarCarWash.setLatitute(chilanzarCarWashingDto.getLatitute());
            chilanzarCarWash.setLongtitute(chilanzarCarWashingDto.getLongtitute());
            chilanzarCarWash.setDescription(chilanzarCarWashingDto.getDescription());
            chilanzarCarWash.setWashMachine(chilanzarCarWashingDto.getWashMachine());
            chilanzarCarWash.setHandWash(chilanzarCarWashingDto.getHandWash());
            chilanzarCarWash.setPrice(chilanzarCarWashingDto.getPrice());
            chilanzarCarWashRepo.save(chilanzarCarWash);
            return new Result("Chilanzar Car Wash Updated successfully", true);
        }
        return new Result("Chilanzar Car Wash Not Found", false);
    }

    public Result delete(UUID id) {
        Optional<ChilanzarCarWash> byId = chilanzarCarWashRepo.findById(id);
        if (byId.isPresent()) {
            chilanzarCarWashRepo.deleteById(id);
            return new Result("Chilanzar Car Wash Deleted successfully", true);
        }
        return new Result("Chilanzar Car Wash Not Found", false);
    }

}