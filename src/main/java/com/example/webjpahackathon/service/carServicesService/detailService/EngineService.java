package com.example.webjpahackathon.service.carServicesService.detailService;

import com.example.webjpahackathon.dto.carServicesDto.detailDto.EngineDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.Engine;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.EngineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EngineService {

    @Autowired
    EngineRepo engineRepo;

    public List<Engine> findAll() {
        return engineRepo.findAll();
    }

    public Engine findById(UUID id) {
        return engineRepo.findById(id).get();
    }

    public Engine findByName(String name) {
        return engineRepo.findByName(name).get();
    }

    public Result create(EngineDto engineDto) {
        Engine engine = new Engine();
        engine.setName(engineDto.getName());
        engine.setDescription(engineDto.getDescription());
        engine.setPrice(engineDto.getPrice());
        engine.setImage(engineDto.getImage());
        engine.setAvailability(engineDto.getAvailability());
        engineRepo.save(engine);
        return new Result("Engine information created successfully", true);
    }

    public Result update(EngineDto engineDto, UUID id) {
        Optional<Engine> byId = engineRepo.findById(id);
        if (byId.isPresent()) {
            Engine engine = byId.get();
            engine.setName(engineDto.getName());
            engine.setDescription(engineDto.getDescription());
            engine.setPrice(engineDto.getPrice());
            engine.setImage(engineDto.getImage());
            engine.setAvailability(engineDto.getAvailability());
            engineRepo.save(engine);
            return new Result("Engine information updated successfully", true);
        }
        return new Result("Engine information not found", false);
    }

    public Result delete(UUID id) {
        Optional<Engine> byId = engineRepo.findById(id);
        if (byId.isPresent()) {
            engineRepo.deleteById(id);
            return new Result("Engine information deleted successfully", true);
        }
        return new Result("Engine information not found", false);
    }

}