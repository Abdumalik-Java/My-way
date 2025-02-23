package com.example.webjpahackathon.service.carServicesService.detailService;

import com.example.webjpahackathon.dto.carServicesDto.detailDto.MirrorsDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.Mirrors;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.MirrorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MirrorsService {

    @Autowired
    MirrorsRepo mirrorsRepo;

    public List<Mirrors> getAllMirrors() {
        return mirrorsRepo.findAll();
    }

    public Mirrors getById(UUID id) {
        return mirrorsRepo.findById(id).get();
    }

    public Mirrors getByName(String name) {
        return mirrorsRepo.findByName(name).get();
    }

    public Result createMirror(MirrorsDto mirrorsDto) {
        Mirrors mirrors = new Mirrors();
        mirrors.setName(mirrorsDto.getName());
        mirrors.setDescription(mirrorsDto.getDescription());
        mirrors.setPrice(mirrorsDto.getPrice());
        mirrors.setImage(mirrorsDto.getImage());
        mirrors.setAvailability(mirrorsDto.getAvailability());
        mirrorsRepo.save(mirrors);
        return new Result("Mirrors information created successfully", true);
    }

    public Result updateMirror(MirrorsDto mirrorsDto, UUID id) {
        Optional<Mirrors> byId = mirrorsRepo.findById(id);
        if (byId.isPresent()) {
            Mirrors mirrors = byId.get();
            mirrors.setName(mirrorsDto.getName());
            mirrors.setDescription(mirrorsDto.getDescription());
            mirrors.setPrice(mirrorsDto.getPrice());
            mirrors.setImage(mirrorsDto.getImage());
            mirrors.setAvailability(mirrorsDto.getAvailability());
            mirrorsRepo.save(mirrors);
            return new Result("Mirrors information updated successfully", true);
        }
        return new Result("Mirrors information not found", false);
    }

    public Result deleteMirror(UUID id) {
        Optional<Mirrors> byId = mirrorsRepo.findById(id);
        if (byId.isPresent()) {
            mirrorsRepo.deleteById(id);
            return new Result("Mirrors information deleted successfully", true);
        }
        return new Result("Mirrors information not found", false);
    }

}