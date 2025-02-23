package com.example.webjpahackathon.service.carServicesService.detailService;

import com.example.webjpahackathon.dto.carServicesDto.detailDto.RoofDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.Roof;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.RoofRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoofService {

    @Autowired
    RoofRepo roofRepo;

    public List<Roof> getAllRoofs() {
        return roofRepo.findAll();
    }

    public Roof getRoofById(UUID id) {
        return roofRepo.findById(id).get();
    }

    public Roof getRoofByName(String name) {
        return roofRepo.findByName(name).get();
    }

    public Result createRoof(RoofDto roofDto) {
        Roof roof = new Roof();
        roof.setName(roofDto.getName());
        roof.setDescription(roofDto.getDescription());
        roof.setPrice(roofDto.getPrice());
        roof.setImage(roofDto.getImage());
        roof.setAvailability(roofDto.getAvailability());
        roofRepo.save(roof);
        return new Result("Roof information created successfully", true);
    }

    public Result updateRoof(RoofDto roofDto, UUID id) {
        Optional<Roof> byId = roofRepo.findById(id);
        if (byId.isPresent()) {
            Roof roof = byId.get();
            roof.setName(roofDto.getName());
            roof.setDescription(roofDto.getDescription());
            roof.setPrice(roofDto.getPrice());
            roof.setImage(roofDto.getImage());
            roof.setAvailability(roofDto.getAvailability());
            roofRepo.save(roof);
            return new Result("Roof information updated successfully", true);
        }
        return new Result("Roof information not found", false);
    }

    public Result deleteRoof(UUID id) {
        Optional<Roof> byId = roofRepo.findById(id);
        if (byId.isPresent()) {
            roofRepo.deleteById(id);
            return new Result("Roof information deleted successfully", true);
        }
        return new Result("Roof information not found", false);
    }

}