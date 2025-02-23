package com.example.webjpahackathon.service.carServicesService.detailService;

import com.example.webjpahackathon.dto.carServicesDto.detailDto.TiresDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.Tires;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.TiresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TiresService {

    @Autowired
    TiresRepo tiresRepo;

    public List<Tires> getAllTires(){
        return tiresRepo.findAll();
    }

    public Tires getTiresById(UUID id) {
        return tiresRepo.findById(id).get();
    }

    public Tires getTiresByName(String name) {
        return tiresRepo.findByName(name).get();
    }

    public Result createTires(TiresDto tiresDto) {
        Tires tires = new Tires();
        tires.setName(tiresDto.getName());
        tires.setDescription(tiresDto.getDescription());
        tires.setPrice(tiresDto.getPrice());
        tires.setImage(tiresDto.getImage());
        tires.setAvailability(tiresDto.getAvailability());
        tiresRepo.save(tires);
        return new Result("Tires information created successfully", true);
    }

    public Result updateTires(UUID id, TiresDto tiresDto) {
        Optional<Tires> byId = tiresRepo.findById(id);
        if (byId.isPresent()) {
            Tires tires = byId.get();
            tires.setName(tiresDto.getName());
            tires.setDescription(tiresDto.getDescription());
            tires.setPrice(tiresDto.getPrice());
            tires.setImage(tiresDto.getImage());
            tires.setAvailability(tiresDto.getAvailability());
            tiresRepo.save(tires);
            return new Result("Tires information updated successfully", true);
        }
        return new Result("Tires information not found", false);
    }

    public Result deleteTires(UUID id) {
        Optional<Tires> byId = tiresRepo.findById(id);
        if (byId.isPresent()) {
            tiresRepo.deleteById(id);
            return new Result("Tires information deleted successfully", true);
        }
        return new Result("Tires information not found", false);
    }

}