package com.example.webjpahackathon.service.carServicesService.washingRegionService;

import com.example.webjpahackathon.dto.carServicesDto.washingRegionDto.YunusobodCarWashingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.washingRegion.YunusobodCarWash;
import com.example.webjpahackathon.repository.carServicesRepo.washingRegion.YunusobodCarWashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class YunusobodCarWashService {

    @Autowired
    YunusobodCarWashRepo yunusobodCarWashRepo;

    public List<YunusobodCarWash> readAll() {
        return yunusobodCarWashRepo.findAll();
    }

    public YunusobodCarWash readById(UUID id) {
        return yunusobodCarWashRepo.findById(id).get();
    }

    public YunusobodCarWash readByName(String name) {
        return yunusobodCarWashRepo.findByBrandName(name).get();
    }

    public Result create(YunusobodCarWashingDto yunusobodCarWashingDto) {
        YunusobodCarWash yunusobodCarWash = new YunusobodCarWash();
        yunusobodCarWash.setBrandName(yunusobodCarWashingDto.getBrandName());
        yunusobodCarWash.setLatitute(yunusobodCarWashingDto.getLatitute());
        yunusobodCarWash.setLongtitute(yunusobodCarWashingDto.getLongtitute());
        yunusobodCarWash.setDescription(yunusobodCarWashingDto.getDescription());
        yunusobodCarWash.setWashMachine(yunusobodCarWashingDto.getWashMachine());
        yunusobodCarWash.setHandWash(yunusobodCarWashingDto.getHandWash());
        yunusobodCarWash.setPrice(yunusobodCarWashingDto.getPrice());
        yunusobodCarWashRepo.save(yunusobodCarWash);
        return new Result("Yunusobod car wash information created successfully", true);
    }

    public Result update(UUID id, YunusobodCarWashingDto yunusobodCarWashingDto) {
        Optional<YunusobodCarWash> byId = yunusobodCarWashRepo.findById(id);
        if (byId.isPresent()) {
            YunusobodCarWash yunusobodCarWash = byId.get();
            yunusobodCarWash.setBrandName(yunusobodCarWashingDto.getBrandName());
            yunusobodCarWash.setLatitute(yunusobodCarWashingDto.getLatitute());
            yunusobodCarWash.setLongtitute(yunusobodCarWashingDto.getLongtitute());
            yunusobodCarWash.setDescription(yunusobodCarWashingDto.getDescription());
            yunusobodCarWash.setWashMachine(yunusobodCarWashingDto.getWashMachine());
            yunusobodCarWash.setHandWash(yunusobodCarWashingDto.getHandWash());
            yunusobodCarWash.setPrice(yunusobodCarWashingDto.getPrice());
            yunusobodCarWashRepo.save(yunusobodCarWash);
            return new Result("Yunusobod car wash information update successfully", true);
        }
        return new Result("Yunusobod car wash information not found", false);
    }

    public Result delete(UUID id) {
        Optional<YunusobodCarWash> byId = yunusobodCarWashRepo.findById(id);
        if (byId.isPresent()) {
            yunusobodCarWashRepo.deleteById(id);
            return new Result("Yunusobod car wash information delete successfully", true);
        }
        return new Result("Yunusobod car wash information not found", false);
    }

}