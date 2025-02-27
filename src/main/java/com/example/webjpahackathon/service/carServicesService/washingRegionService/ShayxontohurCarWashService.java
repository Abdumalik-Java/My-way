package com.example.webjpahackathon.service.carServicesService.washingRegionService;

import com.example.webjpahackathon.dto.carServicesDto.washingRegionDto.ShayxontohurCarWashingDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.washingRegion.ShayxontohurCarWash;
import com.example.webjpahackathon.repository.carServicesRepo.washingRegion.ShayxontohurCarWashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShayxontohurCarWashService {

    @Autowired
    ShayxontohurCarWashRepo shayxontohurCarWashRepo;

    public List<ShayxontohurCarWash> readAll() {
        return shayxontohurCarWashRepo.findAll();
    }

    public ShayxontohurCarWash readById(UUID id) {
        return shayxontohurCarWashRepo.findById(id).get();
    }

    public ShayxontohurCarWash readByName(String name) {
        return shayxontohurCarWashRepo.findByBrandName(name).get();
    }

    public Result create(ShayxontohurCarWashingDto shayxontohurCarWashingDto) {
        ShayxontohurCarWash shayxontohurCarWash = new ShayxontohurCarWash();
        shayxontohurCarWash.setBrandName(shayxontohurCarWashingDto.getBrandName());
        shayxontohurCarWash.setLatitute(shayxontohurCarWashingDto.getLatitute());
        shayxontohurCarWash.setLongtitute(shayxontohurCarWashingDto.getLongtitute());
        shayxontohurCarWash.setDescription(shayxontohurCarWashingDto.getDescription());
        shayxontohurCarWash.setWashMachine(shayxontohurCarWashingDto.getWashMachine());
        shayxontohurCarWash.setHandWash(shayxontohurCarWashingDto.getHandWash());
        shayxontohurCarWash.setPrice(shayxontohurCarWashingDto.getPrice());
        shayxontohurCarWashRepo.save(shayxontohurCarWash);
        return new Result("Shayxontohur car wash information created successfully", true);
    }

    public Result update(UUID id, ShayxontohurCarWashingDto shayxontohurCarWashingDto) {
        Optional<ShayxontohurCarWash> byId = shayxontohurCarWashRepo.findById(id);
        if (byId.isPresent()) {
            ShayxontohurCarWash shayxontohurCarWash = byId.get();
            shayxontohurCarWash.setBrandName(shayxontohurCarWashingDto.getBrandName());
            shayxontohurCarWash.setLatitute(shayxontohurCarWashingDto.getLatitute());
            shayxontohurCarWash.setLongtitute(shayxontohurCarWashingDto.getLongtitute());
            shayxontohurCarWash.setDescription(shayxontohurCarWashingDto.getDescription());
            shayxontohurCarWash.setWashMachine(shayxontohurCarWashingDto.getWashMachine());
            shayxontohurCarWash.setHandWash(shayxontohurCarWashingDto.getHandWash());
            shayxontohurCarWash.setPrice(shayxontohurCarWashingDto.getPrice());
            shayxontohurCarWashRepo.save(shayxontohurCarWash);
            return new Result("Shayxontohur car wash information updated successfully", true);
        }
        return new Result("Shayxontohur car wash information not found", false);
    }

    public Result delete(UUID id) {
        Optional<ShayxontohurCarWash> byId = shayxontohurCarWashRepo.findById(id);
        if (byId.isPresent()) {
            shayxontohurCarWashRepo.deleteById(id);
            return new Result("Shayxontohur car wash information deleted successfully", true);
        }
        return new Result("Shayxontohur car wash information not found", false);
    }

}