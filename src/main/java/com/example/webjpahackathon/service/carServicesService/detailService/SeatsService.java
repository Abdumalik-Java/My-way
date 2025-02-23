package com.example.webjpahackathon.service.carServicesService.detailService;

import com.example.webjpahackathon.dto.carServicesDto.detailDto.SeatsDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.Seats;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.SeatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SeatsService {

    @Autowired
    SeatsRepo seatsRepo;

    public List<Seats> getAllSeats() {
        return seatsRepo.findAll();
    }

    public Seats getSeatById(UUID id) {
        return seatsRepo.findById(id).get();
    }

    public Seats getSeatByName(String name) {
        return seatsRepo.findByName(name).get();
    }

    public Result createSeat(SeatsDto seatsDto) {
        Seats seats = new Seats();
        seats.setName(seatsDto.getName());
        seats.setDescription(seatsDto.getDescription());
        seats.setPrice(seatsDto.getPrice());
        seats.setImage(seatsDto.getImage());
        seats.setAvailability(seatsDto.getAvailability());
        seatsRepo.save(seats);
        return new Result("Seat information created successfully", true);
    }

    public Result updateSeat(UUID id, SeatsDto seatsDto) {
        Optional<Seats> byId = seatsRepo.findById(id);
        if (byId.isPresent()) {
            Seats seats = byId.get();
            seats.setName(seatsDto.getName());
            seats.setDescription(seatsDto.getDescription());
            seats.setPrice(seatsDto.getPrice());
            seats.setImage(seatsDto.getImage());
            seats.setAvailability(seatsDto.getAvailability());
            seatsRepo.save(seats);
            return new Result("Seat information updated successfully", true);
        }
        return new Result("Seat information not found", false);
    }

    public Result deleteSeat(UUID id) {
        Optional<Seats> byId = seatsRepo.findById(id);
        if (byId.isPresent()) {
            seatsRepo.deleteById(id);
            return new Result("Seat information deleted successfully", true);
        }
        return new Result("Seat information not found", false);
    }

}