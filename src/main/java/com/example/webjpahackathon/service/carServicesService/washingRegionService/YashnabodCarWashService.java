package com.example.webjpahackathon.service.carServicesService.washingRegionService;

import com.example.webjpahackathon.dto.carServicesDto.washingRegionDto.YashnabodCarWashingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.washingRegion.YashnabodCarWash;
import com.example.webjpahackathon.repository.carServicesRepo.washingRegion.YashnabodCarWashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class YashnabodCarWashService {

    @Autowired
    YashnabodCarWashRepo yashnabodCarWashRepo;

    public List<YashnabodCarWash> readAll() {
        return yashnabodCarWashRepo.findAll();
    }

    public YashnabodCarWash readById(UUID id) {
        return yashnabodCarWashRepo.findById(id).get();
    }

    public YashnabodCarWash readByName(String name) {
        return yashnabodCarWashRepo.findByBrandName(name).get();
    }

    public Result create(YashnabodCarWashingDto yashnabodCarWashingDto) {
        YashnabodCarWash yashnabodCarWash = new YashnabodCarWash();
        yashnabodCarWash.setBrandName(yashnabodCarWashingDto.getBrandName());
        yashnabodCarWash.setLatitute(yashnabodCarWashingDto.getLatitute());
        yashnabodCarWash.setLongtitute(yashnabodCarWashingDto.getLongtitute());
        yashnabodCarWash.setDescription(yashnabodCarWashingDto.getDescription());
        yashnabodCarWash.setWashMachine(yashnabodCarWashingDto.getWashMachine());
        yashnabodCarWash.setHandWash(yashnabodCarWashingDto.getHandWash());
        yashnabodCarWash.setPrice(yashnabodCarWashingDto.getPrice());
        yashnabodCarWashRepo.save(yashnabodCarWash);
        return new Result("Yashnabod car wash information created successfully", true);
    }

    public Result update(UUID id, YashnabodCarWashingDto yashnabodCarWashingDto) {
        Optional<YashnabodCarWash> byId = yashnabodCarWashRepo.findById(id);
        if (byId.isPresent()) {
            YashnabodCarWash yashnabodCarWash = byId.get();
            yashnabodCarWash.setBrandName(yashnabodCarWashingDto.getBrandName());
            yashnabodCarWash.setLatitute(yashnabodCarWashingDto.getLatitute());
            yashnabodCarWash.setLongtitute(yashnabodCarWashingDto.getLongtitute());
            yashnabodCarWash.setDescription(yashnabodCarWashingDto.getDescription());
            yashnabodCarWash.setWashMachine(yashnabodCarWashingDto.getWashMachine());
            yashnabodCarWash.setHandWash(yashnabodCarWashingDto.getHandWash());
            yashnabodCarWash.setPrice(yashnabodCarWashingDto.getPrice());
            yashnabodCarWashRepo.save(yashnabodCarWash);
            return new Result("Yashnabod car wash information updated successfully", true);
        }
        return new Result("Yashnabod car wash information not found", false);
    }

    public Result delete(UUID id) {
        Optional<YashnabodCarWash> byId = yashnabodCarWashRepo.findById(id);
        if (byId.isPresent()) {
            yashnabodCarWashRepo.deleteById(id);
            return new Result("Yashnabod car wash information updated successfully", true);
        }
        return new Result("Yashnabod car wash information not found", false);
    }

}