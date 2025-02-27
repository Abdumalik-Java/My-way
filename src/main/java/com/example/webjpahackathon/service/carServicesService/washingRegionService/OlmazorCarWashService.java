package com.example.webjpahackathon.service.carServicesService.washingRegionService;

import com.example.webjpahackathon.dto.carServicesDto.washingRegionDto.OlmazorCarWashingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.washingRegion.OlmazorCarWash;
import com.example.webjpahackathon.repository.carServicesRepo.washingRegion.OlmazorCarWashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OlmazorCarWashService {

    @Autowired
    OlmazorCarWashRepo olmazorCarWashRepo;

    public List<OlmazorCarWash> readAllOlmazorCarWash() {
        return olmazorCarWashRepo.findAll();
    }

    public OlmazorCarWash readOlmazorCarWash(UUID id) {
        return olmazorCarWashRepo.findById(id).get();
    }

    public OlmazorCarWash readByName(String name) {
        return olmazorCarWashRepo.findByBrandName(name).get();
    }

    public Result create(OlmazorCarWashingDto olmazorCarWashingDto) {
        OlmazorCarWash olmazorCarWash = new OlmazorCarWash();
        olmazorCarWash.setBrandName(olmazorCarWashingDto.getBrandName());
        olmazorCarWash.setLatitute(olmazorCarWashingDto.getLatitute());
        olmazorCarWash.setLongtitute(olmazorCarWashingDto.getLongtitute());
        olmazorCarWash.setDescription(olmazorCarWashingDto.getDescription());
        olmazorCarWash.setWashMachine(olmazorCarWashingDto.getWashMachine());
        olmazorCarWash.setHandWash(olmazorCarWashingDto.getHandWash());
        olmazorCarWash.setPrice(olmazorCarWashingDto.getPrice());
        olmazorCarWashRepo.save(olmazorCarWash);
        return new Result("Olmazor Car Wash Created", true);
    }

    public Result update(UUID id, OlmazorCarWashingDto olmazorCarWashingDto) {
        Optional<OlmazorCarWash> byId = olmazorCarWashRepo.findById(id);
        if (byId.isPresent()) {
            OlmazorCarWash olmazorCarWash = byId.get();
            olmazorCarWash.setBrandName(olmazorCarWashingDto.getBrandName());
            olmazorCarWash.setLatitute(olmazorCarWashingDto.getLatitute());
            olmazorCarWash.setLongtitute(olmazorCarWashingDto.getLongtitute());
            olmazorCarWash.setDescription(olmazorCarWashingDto.getDescription());
            olmazorCarWash.setWashMachine(olmazorCarWashingDto.getWashMachine());
            olmazorCarWash.setHandWash(olmazorCarWashingDto.getHandWash());
            olmazorCarWash.setPrice(olmazorCarWashingDto.getPrice());
            olmazorCarWashRepo.save(olmazorCarWash);
            return new Result("Olmazor Car Wash Updated", true);
        }
        return new Result("Olmazor Car Wash Not Found", false);
    }

    public Result delete(UUID id) {
        Optional<OlmazorCarWash> byId = olmazorCarWashRepo.findById(id);
        if (byId.isPresent()) {
            olmazorCarWashRepo.deleteById(id);
            return new Result("Olmazor Car Wash Deleted", true);
        }
        return new Result("Olmazor Car Wash Not Found", false);
    }

}