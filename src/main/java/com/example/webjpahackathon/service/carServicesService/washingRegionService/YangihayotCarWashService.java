package com.example.webjpahackathon.service.carServicesService.washingRegionService;

import com.example.webjpahackathon.dto.carServicesDto.washingRegionDto.YangihayotCarWashingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.washingRegion.YangihayotCarWash;
import com.example.webjpahackathon.repository.carServicesRepo.washingRegion.YangihayotCarWashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class YangihayotCarWashService {

    @Autowired
    YangihayotCarWashRepo yangihayotCarWashRepo;

    public List<YangihayotCarWash> readAll() {
        return yangihayotCarWashRepo.findAll();
    }

    public YangihayotCarWash readById(UUID id) {
        return yangihayotCarWashRepo.findById(id).get();
    }

    public YangihayotCarWash readByName(String name) {
        return yangihayotCarWashRepo.findByBrandName(name).get();
    }

    public Result create(YangihayotCarWashingDto yangihayotCarWashingDto) {
        YangihayotCarWash yangihayotCarWash = new YangihayotCarWash();
        yangihayotCarWash.setBrandName(yangihayotCarWashingDto.getBrandName());
        yangihayotCarWash.setLatitute(yangihayotCarWashingDto.getLatitute());
        yangihayotCarWash.setLongtitute(yangihayotCarWashingDto.getLongtitute());
        yangihayotCarWash.setDescription(yangihayotCarWashingDto.getDescription());
        yangihayotCarWash.setWashMachine(yangihayotCarWashingDto.getWashMachine());
        yangihayotCarWash.setHandWash(yangihayotCarWashingDto.getHandWash());
        yangihayotCarWash.setPrice(yangihayotCarWashingDto.getPrice());
        yangihayotCarWashRepo.save(yangihayotCarWash);
        return new Result("Yangihayot car wash information created successfully", true);
    }

    public Result update(UUID id, YangihayotCarWashingDto yangihayotCarWashingDto) {
        Optional<YangihayotCarWash> byId = yangihayotCarWashRepo.findById(id);
        if (byId.isPresent()) {
            YangihayotCarWash yangihayotCarWash = byId.get();
            yangihayotCarWash.setBrandName(yangihayotCarWashingDto.getBrandName());
            yangihayotCarWash.setLatitute(yangihayotCarWashingDto.getLatitute());
            yangihayotCarWash.setLongtitute(yangihayotCarWashingDto.getLongtitute());
            yangihayotCarWash.setDescription(yangihayotCarWashingDto.getDescription());
            yangihayotCarWash.setWashMachine(yangihayotCarWashingDto.getWashMachine());
            yangihayotCarWash.setHandWash(yangihayotCarWashingDto.getHandWash());
            yangihayotCarWash.setPrice(yangihayotCarWashingDto.getPrice());
            yangihayotCarWashRepo.save(yangihayotCarWash);
            return new Result("Yangihayot car wash information updated successfully", true);
        }
        return new Result("Yangihayot car wash information not found", false);
    }

    public Result delete(UUID id) {
        Optional<YangihayotCarWash> byId = yangihayotCarWashRepo.findById(id);
        if (byId.isPresent()) {
            yangihayotCarWashRepo.deleteById(id);
            return new Result("Yangihayot car wash information deleted successfully", true);
        }
        return new Result("Yangihayot car wash information not found", false);
    }

}