package com.example.webjpahackathon.service.carServicesService.detailService;

import com.example.webjpahackathon.dto.carServicesDto.detailDto.BumperDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.Bumper;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.BumperRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BumperService {

    @Autowired
    BumperRepo bumperRepo;

    public List<Bumper> readAll() {
        return bumperRepo.findAll();
    }

    public Bumper readById(UUID id) {
        return bumperRepo.findById(id).get();
    }

    public Bumper readByName(String name) {
        return bumperRepo.findByName(name).get();
    }

    public Result create(BumperDto bumperDto) {
        Bumper bumper = new Bumper();
        bumper.setName(bumperDto.getName());
        bumper.setDescription(bumperDto.getDescription());
        bumper.setPrice(bumperDto.getPrice());
        bumper.setImage(bumperDto.getImage());
        bumper.setAvailability(bumperDto.getAvailability());
        bumperRepo.save(bumper);
        return new Result("Bumper information created successfully", true);
    }

    public Result update(BumperDto bumperDto, UUID id) {
        Optional<Bumper> byId = bumperRepo.findById(id);
        if (byId.isPresent()) {
            Bumper bumper = byId.get();
            bumper.setName(bumperDto.getName());
            bumper.setDescription(bumperDto.getDescription());
            bumper.setPrice(bumperDto.getPrice());
            bumper.setImage(bumperDto.getImage());
            bumper.setAvailability(bumperDto.getAvailability());
            bumperRepo.save(bumper);
            return new Result("Bumper information updated successfully", true);
        }
        return new Result("Bumper information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Bumper> byId = bumperRepo.findById(id);
        if (byId.isPresent()) {
            bumperRepo.deleteById(id);
            return new Result("Bumper information deleted successfully", true);
        }
        return new Result("Bumper information not found", false);
    }

}