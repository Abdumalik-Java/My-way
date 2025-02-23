package com.example.webjpahackathon.service.carServicesService.detailService;

import com.example.webjpahackathon.dto.carServicesDto.detailDto.WheelsDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.Wheels;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.WheelsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WheelsService {

    @Autowired
    WheelsRepo wheelsRepo;

    public List<Wheels> getAllWheels() {
        return wheelsRepo.findAll();
    }

    public Wheels getWheelById(UUID id) {
        return wheelsRepo.findById(id).get();
    }

    public Wheels getWheelByName(String name) {
        return wheelsRepo.findByName(name).get();
    }

    public Result createWheel(WheelsDto wheelsDto) {
        Wheels wheels = new Wheels();
        wheels.setName(wheelsDto.getName());
        wheels.setDescription(wheelsDto.getDescription());
        wheels.setPrice(wheelsDto.getPrice());
        wheels.setImage(wheelsDto.getImage());
        wheels.setAvailability(wheelsDto.getAvailability());
        wheelsRepo.save(wheels);
        return new Result("Wheels created successfully", true);
    }

    public Result updateWheel(WheelsDto wheelsDto, UUID id) {
        Optional<Wheels> byId = wheelsRepo.findById(id);
        if (byId.isPresent()) {
            Wheels wheels = byId.get();
            wheels.setName(wheelsDto.getName());
            wheels.setDescription(wheelsDto.getDescription());
            wheels.setPrice(wheelsDto.getPrice());
            wheels.setImage(wheelsDto.getImage());
            wheels.setAvailability(wheelsDto.getAvailability());
            wheelsRepo.save(wheels);
            return new Result("Wheels updated successfully", true);
        }
        return new Result("Wheels not found", false);
    }

    public Result deleteWheel(UUID id) {
        Optional<Wheels> byId = wheelsRepo.findById(id);
        if (byId.isPresent()) {
            wheelsRepo.deleteById(id);
            return new Result("Wheels deleted successfully", true);
        }
        return new Result("Wheels not found", false);
    }

}