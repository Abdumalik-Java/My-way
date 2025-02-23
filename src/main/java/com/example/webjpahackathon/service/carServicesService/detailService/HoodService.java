package com.example.webjpahackathon.service.carServicesService.detailService;

import com.example.webjpahackathon.dto.carServicesDto.detailDto.HoodDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.Hood;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.HoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HoodService {

    @Autowired
    HoodRepo hoodRepo;

    public List<Hood> getAllHoods() {
        return hoodRepo.findAll();
    }

    public Hood getHoodById(UUID id) {
        return hoodRepo.findById(id).get();
    }

    public Hood getHoodByName(String name) {
        return hoodRepo.findByName(name).get();
    }

    public Result createHood(HoodDto hoodDto) {
        Hood hood = new Hood();
        hood.setName(hoodDto.getName());
        hood.setDescription(hoodDto.getDescription());
        hood.setPrice(hoodDto.getPrice());
        hood.setImage(hoodDto.getImage());
        hood.setAvailability(hoodDto.getAvailability());
        hoodRepo.save(hood);
        return new Result("Hood information created successfully", true);
    }

    public Result updateHood(HoodDto hoodDto, UUID id) {
        Optional<Hood> byId = hoodRepo.findById(id);
        if (byId.isPresent()) {
            Hood hood = byId.get();
            hood.setName(hoodDto.getName());
            hood.setDescription(hoodDto.getDescription());
            hood.setPrice(hoodDto.getPrice());
            hood.setImage(hoodDto.getImage());
            hood.setAvailability(hoodDto.getAvailability());
            hoodRepo.save(hood);
            return new Result("Hood information updated successfully", true);
        }
        return new Result("Hood information not found", false);
    }

    public Result deleteHood(UUID id) {
        Optional<Hood> byId = hoodRepo.findById(id);
        if (byId.isPresent()) {
            hoodRepo.deleteById(id);
            return new Result("Hood information deleted successfully", true);
        }
        return new Result("Hood information not found", false);
    }

}