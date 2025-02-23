package com.example.webjpahackathon.service.carServicesService.detailService;

import com.example.webjpahackathon.dto.carServicesDto.detailDto.TransmissionDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.Transmission;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.TransmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransmissionService {

    @Autowired
    TransmissionRepo transmissionRepo;

    public List<Transmission> getAllTransmissions() {
        return transmissionRepo.findAll();
    }

    public Transmission getTransmissionById(UUID id) {
        return transmissionRepo.findById(id).get();
    }

    public Transmission getTransmissionByName(String name) {
        return transmissionRepo.findByName(name).get();
    }

    public Result createTransmission(TransmissionDto transmissionDto) {
        Transmission transmission = new Transmission();
        transmission.setName(transmissionDto.getName());
        transmission.setDescription(transmissionDto.getDescription());
        transmission.setPrice(transmissionDto.getPrice());
        transmission.setImage(transmissionDto.getImage());
        transmission.setAvailability(transmissionDto.getAvailability());
        transmissionRepo.save(transmission);
        return new Result("Transmission information created successfully", true);
    }

    public Result updateTransmission(UUID id, TransmissionDto transmissionDto) {
        Optional<Transmission> byId = transmissionRepo.findById(id);
        if (byId.isPresent()) {
            Transmission transmission = byId.get();
            transmission.setName(transmissionDto.getName());
            transmission.setDescription(transmissionDto.getDescription());
            transmission.setPrice(transmissionDto.getPrice());
            transmission.setImage(transmissionDto.getImage());
            transmission.setAvailability(transmissionDto.getAvailability());
            transmissionRepo.save(transmission);
            return new Result("Transmission information updated successfully", true);
        }
        return new Result("Transmission information not found", false);
    }

    public Result deleteTransmission(UUID id) {
        Optional<Transmission> byId = transmissionRepo.findById(id);
        if (byId.isPresent()) {
            transmissionRepo.deleteById(id);
            return new Result("Transmission information deleted successfully", true);
        }
        return new Result("Transmission information not found", false);
    }

}