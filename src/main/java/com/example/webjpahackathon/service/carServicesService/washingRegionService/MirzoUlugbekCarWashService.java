package com.example.webjpahackathon.service.carServicesService.washingRegionService;

import com.example.webjpahackathon.dto.carServicesDto.washingRegionDto.MirzoUlugbekCarWashingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.washingRegion.MirzoUlugbekCarWash;
import com.example.webjpahackathon.repository.carServicesRepo.washingRegion.MirzoUlugbekCarWashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MirzoUlugbekCarWashService {

    @Autowired
    MirzoUlugbekCarWashRepo mirzoUlugbekCarWashRepo;

    public List<MirzoUlugbekCarWash> readAllMirzoUlugbekCarWash() {
        return mirzoUlugbekCarWashRepo.findAll();
    }

    public MirzoUlugbekCarWash readMirzoUlugbekCarWash(UUID id) {
        return mirzoUlugbekCarWashRepo.findById(id).get();
    }

    public MirzoUlugbekCarWash readByName(String name) {
        return mirzoUlugbekCarWashRepo.findByBrandName(name).get();
    }

    public Result create(MirzoUlugbekCarWashingDto mirzoUlugbekCarWashingDto) {
        MirzoUlugbekCarWash mirzoUlugbekCarWash = new MirzoUlugbekCarWash();
        mirzoUlugbekCarWash.setBrandName(mirzoUlugbekCarWashingDto.getBrandName());
        mirzoUlugbekCarWash.setLatitute(mirzoUlugbekCarWashingDto.getLatitute());
        mirzoUlugbekCarWash.setLongtitute(mirzoUlugbekCarWashingDto.getLongtitute());
        mirzoUlugbekCarWash.setDescription(mirzoUlugbekCarWashingDto.getDescription());
        mirzoUlugbekCarWash.setWashMachine(mirzoUlugbekCarWashingDto.getWashMachine());
        mirzoUlugbekCarWash.setHandWash(mirzoUlugbekCarWashingDto.getHandWash());
        mirzoUlugbekCarWash.setPrice(mirzoUlugbekCarWashingDto.getPrice());
        mirzoUlugbekCarWashRepo.save(mirzoUlugbekCarWash);
        return new Result("Mirobod Car Wash Created", true);
    }

    public Result update(MirzoUlugbekCarWashingDto mirzoUlugbekCarWashingDto, UUID id) {
        Optional<MirzoUlugbekCarWash> byId = mirzoUlugbekCarWashRepo.findById(id);
        if (byId.isPresent()) {
            MirzoUlugbekCarWash mirzoUlugbekCarWash = byId.get();
            mirzoUlugbekCarWash.setBrandName(mirzoUlugbekCarWashingDto.getBrandName());
            mirzoUlugbekCarWash.setLatitute(mirzoUlugbekCarWashingDto.getLatitute());
            mirzoUlugbekCarWash.setLongtitute(mirzoUlugbekCarWashingDto.getLongtitute());
            mirzoUlugbekCarWash.setDescription(mirzoUlugbekCarWashingDto.getDescription());
            mirzoUlugbekCarWash.setWashMachine(mirzoUlugbekCarWashingDto.getWashMachine());
            mirzoUlugbekCarWash.setHandWash(mirzoUlugbekCarWashingDto.getHandWash());
            mirzoUlugbekCarWash.setPrice(mirzoUlugbekCarWashingDto.getPrice());
            mirzoUlugbekCarWashRepo.save(mirzoUlugbekCarWash);
            return new Result("Mirobod Car Wash Updated", true);
        }
        return new Result("Mirobod Car Wash Not Found", false);
    }

    public Result delete(UUID id) {
        Optional<MirzoUlugbekCarWash> byId = mirzoUlugbekCarWashRepo.findById(id);
        if (byId.isPresent()) {
            mirzoUlugbekCarWashRepo.deleteById(id);
            return new Result("Mirobod Car Wash Deleted", true);
        }
        return new Result("Mirobod Car Wash Not Found", false);
    }

}