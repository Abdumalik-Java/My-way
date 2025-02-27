package com.example.webjpahackathon.service.carServicesService.washingRegionService;

import com.example.webjpahackathon.dto.carServicesDto.washingRegionDto.MirobodCarWashingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.washingRegion.MirobodCarWash;
import com.example.webjpahackathon.repository.carServicesRepo.washingRegion.MirobodCarWashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MirobodCarWashService {

    @Autowired
    MirobodCarWashRepo mirobodCarWashRepo;

    public List<MirobodCarWash> getAllMirobodCarWash() {
        return mirobodCarWashRepo.findAll();
    }

    public MirobodCarWash getMirobodCarWashById(UUID id) {
        return mirobodCarWashRepo.findById(id).get();
    }

    public MirobodCarWash getMirobodCarWashByName(String name) {
        return mirobodCarWashRepo.findByBrandName(name).get();
    }

    public Result create(MirobodCarWashingDto mirobodCarWashingDto) {
        MirobodCarWash mirobodCarWash = new MirobodCarWash();
        mirobodCarWash.setBrandName(mirobodCarWashingDto.getBrandName());
        mirobodCarWash.setLatitute(mirobodCarWashingDto.getLatitute());
        mirobodCarWash.setLongtitute(mirobodCarWashingDto.getLongtitute());
        mirobodCarWash.setDescription(mirobodCarWashingDto.getDescription());
        mirobodCarWash.setWashMachine(mirobodCarWashingDto.getWashMachine());
        mirobodCarWash.setHandWash(mirobodCarWashingDto.getHandWash());
        mirobodCarWash.setPrice(mirobodCarWashingDto.getPrice());
        mirobodCarWashRepo.save(mirobodCarWash);
        return new Result("Mirobod Car Wash Created", true);
    }

    public Result update(MirobodCarWashingDto mirobodCarWashingDto, UUID id) {
        Optional<MirobodCarWash> byId = mirobodCarWashRepo.findById(id);
        if (byId.isPresent()) {
            MirobodCarWash mirobodCarWash = byId.get();
            mirobodCarWash.setBrandName(mirobodCarWashingDto.getBrandName());
            mirobodCarWash.setLatitute(mirobodCarWashingDto.getLatitute());
            mirobodCarWash.setLongtitute(mirobodCarWashingDto.getLongtitute());
            mirobodCarWash.setDescription(mirobodCarWashingDto.getDescription());
            mirobodCarWash.setWashMachine(mirobodCarWashingDto.getWashMachine());
            mirobodCarWash.setHandWash(mirobodCarWashingDto.getHandWash());
            mirobodCarWash.setPrice(mirobodCarWashingDto.getPrice());
            mirobodCarWashRepo.save(mirobodCarWash);
            return new Result("Mirobod Car Wash Updated", true);
        }
        return new Result("Mirobod Car Wash Not Found", false);
    }

    public Result delete(UUID id) {
        Optional<MirobodCarWash> byId = mirobodCarWashRepo.findById(id);
        if (byId.isPresent()) {
            mirobodCarWashRepo.deleteById(id);
            return new Result("Mirobod Car Wash Deleted", true);
        }
        return new Result("Mirobod Car Wash Not Found", false);
    }

}