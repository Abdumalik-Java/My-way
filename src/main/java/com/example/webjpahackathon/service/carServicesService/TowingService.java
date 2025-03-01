package com.example.webjpahackathon.service.carServicesService;

import com.example.webjpahackathon.dto.carServicesDto.TowingServicesDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.TowingServices;
import com.example.webjpahackathon.repository.carServicesRepo.TowingServicesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TowingService {

    @Autowired
    TowingServicesRepo towingServicesRepo;

    public List<TowingServices> readAll() {
        return towingServicesRepo.findAll();
    }

    public TowingServices readById(UUID id) {
        return towingServicesRepo.findById(id).get();
    }

    public Result create(TowingServicesDto towingServicesDto) {
        TowingServices towingServices = new TowingServices();
        towingServices.setPhoneNumber(towingServicesDto.getPhoneNumber());
        towingServices.setLatitude(towingServicesDto.getLatitude());
        towingServices.setLongitude(towingServicesDto.getLongitude());
        towingServices.setPrice(towingServicesDto.getPrice());
        towingServicesRepo.save(towingServices);
        return new Result("Towing services information created successfully", true);
    }

    public Result update(UUID id, TowingServicesDto dto) {
        Optional<TowingServices> byId = towingServicesRepo.findById(id);
        if (byId.isPresent()) {
            TowingServices towingServices = byId.get();
            towingServices.setPhoneNumber(dto.getPhoneNumber());
            towingServices.setLatitude(dto.getLatitude());
            towingServices.setLongitude(dto.getLongitude());
            towingServices.setPrice(dto.getPrice());
            towingServicesRepo.save(towingServices);
            return new Result("Towing services information updated successfully", true);
        }
        return new Result("Towing services information not found", false);
    }

    public Result delete(UUID id) {
        Optional<TowingServices> byId = towingServicesRepo.findById(id);
        if (byId.isPresent()) {
            towingServicesRepo.deleteById(id);
            return new Result("Towing services information deleted successfully", true);
        }
        return new Result("Towing services information not found", false);
    }

}