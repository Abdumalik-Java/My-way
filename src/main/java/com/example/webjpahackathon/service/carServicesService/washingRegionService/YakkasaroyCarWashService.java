package com.example.webjpahackathon.service.carServicesService.washingRegionService;

import com.example.webjpahackathon.dto.carServicesDto.washingRegionDto.YakkasaroyCarWashingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.washingRegion.YakkasaroyCarWash;
import com.example.webjpahackathon.repository.carServicesRepo.washingRegion.YakkasaroyCarWashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class YakkasaroyCarWashService {

    @Autowired
    YakkasaroyCarWashRepo yakkasaroyCarWashRepo;

    public List<YakkasaroyCarWash> readAll() {
        return yakkasaroyCarWashRepo.findAll();
    }

    public YakkasaroyCarWash readById(UUID id) {
        return yakkasaroyCarWashRepo.findById(id).get();
    }

    public YakkasaroyCarWash readByName(String name) {
        return yakkasaroyCarWashRepo.findByBrandName(name).get();
    }

    public Result create(YakkasaroyCarWashingDto yakkasaroyCarWashingDto) {
        YakkasaroyCarWash yakkasaroyCarWash = new YakkasaroyCarWash();
        yakkasaroyCarWash.setBrandName(yakkasaroyCarWashingDto.getBrandName());
        yakkasaroyCarWash.setLatitute(yakkasaroyCarWashingDto.getLatitute());
        yakkasaroyCarWash.setLongtitute(yakkasaroyCarWashingDto.getLongtitute());
        yakkasaroyCarWash.setDescription(yakkasaroyCarWashingDto.getDescription());
        yakkasaroyCarWash.setWashMachine(yakkasaroyCarWashingDto.getWashMachine());
        yakkasaroyCarWash.setHandWash(yakkasaroyCarWashingDto.getHandWash());
        yakkasaroyCarWash.setPrice(yakkasaroyCarWashingDto.getPrice());
        yakkasaroyCarWashRepo.save(yakkasaroyCarWash);
        return new Result("Yakkasaroy car wash information created successfully", true);
    }

    public Result update(UUID id, YakkasaroyCarWashingDto yakkasaroyCarWashingDto) {
        Optional<YakkasaroyCarWash> byId = yakkasaroyCarWashRepo.findById(id);
        if (byId.isPresent()) {
            YakkasaroyCarWash yakkasaroyCarWash = byId.get();
            yakkasaroyCarWash.setBrandName(yakkasaroyCarWashingDto.getBrandName());
            yakkasaroyCarWash.setLatitute(yakkasaroyCarWashingDto.getLatitute());
            yakkasaroyCarWash.setLongtitute(yakkasaroyCarWashingDto.getLongtitute());
            yakkasaroyCarWash.setDescription(yakkasaroyCarWashingDto.getDescription());
            yakkasaroyCarWash.setWashMachine(yakkasaroyCarWashingDto.getWashMachine());
            yakkasaroyCarWash.setHandWash(yakkasaroyCarWashingDto.getHandWash());
            yakkasaroyCarWash.setPrice(yakkasaroyCarWashingDto.getPrice());
            yakkasaroyCarWashRepo.save(yakkasaroyCarWash);
            return new Result("Yakkasaroy car wash information updated successfully", true);
        }
        return new Result("Yakkasaroy car wash information not found", false);
    }

    public Result delete(UUID id) {
        Optional<YakkasaroyCarWash> byId = yakkasaroyCarWashRepo.findById(id);
        if (byId.isPresent()) {
            yakkasaroyCarWashRepo.deleteById(id);
            return new Result("Yakkasaroy car wash information deleted successfully", true);
        }
        return new Result("Yakkasaroy car wash information not found", false);
    }

}