package com.example.webjpahackathon.service.carServicesService.detailService;

import com.example.webjpahackathon.dto.carServicesDto.detailDto.DoorDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.Door;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.DoorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoorService {

    @Autowired
    DoorRepo doorRepo;

    public List<Door> readAllDoors() {
        return doorRepo.findAll();
    }

    public Door readDoorById(UUID id) {
        return doorRepo.findById(id).get();
    }

    public Door readByName(String name) {
        return doorRepo.findByName(name).get();
    }

    public Result createDoor(DoorDto doorDto) {
        Door door = new Door();
        door.setName(doorDto.getName());
        door.setDescription(doorDto.getDescription());
        door.setPrice(doorDto.getPrice());
        door.setImage(doorDto.getImage());
        door.setAvailability(doorDto.getAvailability());
        doorRepo.save(door);
        return new Result("Door information created successfully", true);
    }

    public Result updateDoor(DoorDto doorDto, UUID id) {
        Optional<Door> byId = doorRepo.findById(id);
        if (byId.isPresent()) {
            Door door = byId.get();
            door.setName(doorDto.getName());
            door.setDescription(doorDto.getDescription());
            door.setPrice(doorDto.getPrice());
            door.setImage(doorDto.getImage());
            door.setAvailability(doorDto.getAvailability());
            doorRepo.save(door);
            return new Result("Door information updated successfully", true);
        }
        return new Result("Door information not found", false);
    }

    public Result deleteDoor(UUID id) {
        Optional<Door> byId = doorRepo.findById(id);
        if (byId.isPresent()) {
            doorRepo.deleteById(id);
            return new Result("Door information deleted successfully", true);
        }
        return new Result("Door information not found", false);
    }

}