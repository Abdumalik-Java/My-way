package com.example.webjpahackathon.service.carServicesService.detailRegionService;

import com.example.webjpahackathon.dto.carServicesDto.detailRegionDto.ChilanzarDetailDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.*;
import com.example.webjpahackathon.model.carServices.detailRegion.ChilanzarDetail;
import com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo.ChilanzarDetailRepo;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChilanzarDetailService {

    @Autowired
    ChilanzarDetailRepo chilanzarDetailRepo;

    @Autowired
    BumperRepo bumperRepo;

    @Autowired
    DoorRepo doorRepo;

    @Autowired
    EngineRepo engineRepo;

    @Autowired
    HoodRepo hoodRepo;

    @Autowired
    MirrorsRepo mirrorsRepo;

    @Autowired
    RoofRepo roofRepo;

    @Autowired
    SeatsRepo seatsRepo;

    @Autowired
    TiresRepo tiresRepo;

    @Autowired
    TransmissionRepo transmissionRepo;

    @Autowired
    WheelsRepo wheelsRepo;

    public List<ChilanzarDetail> readAllChilanzarDetails() {
        return chilanzarDetailRepo.findAll();
    }

    public ChilanzarDetail readChilanzarDetailById(UUID id) {
        return chilanzarDetailRepo.findById(id).get();
    }

    public ChilanzarDetail readChilanzarDetailByName(String name) {
        return chilanzarDetailRepo.findByStoreName(name).get();
    }

    public Result createChilanzarDetail(ChilanzarDetailDto chilanzarDetailDto) {
        ChilanzarDetail chilanzarDetail = new ChilanzarDetail();
        chilanzarDetail.setStoreName(chilanzarDetailDto.getStoreName());
        chilanzarDetail.setLongtitute(chilanzarDetailDto.getLongtitute());
        chilanzarDetail.setLatitute(chilanzarDetailDto.getLatitute());

        Optional<Bumper> byId = bumperRepo.findById(chilanzarDetailDto.getBumperDto());
        Bumper bumper = byId.get();
        chilanzarDetail.setBumper(bumper);

        Optional<Door> byId1 = doorRepo.findById(chilanzarDetailDto.getDoorDto());
        Door door = byId1.get();
        chilanzarDetail.setDoor(door);

        Optional<Engine> byId2 = engineRepo.findById(chilanzarDetailDto.getEngineDto());
        Engine engine = byId2.get();
        chilanzarDetail.setEngine(engine);

        Optional<Hood> byId3 = hoodRepo.findById(chilanzarDetailDto.getHoodDto());
        Hood hood = byId3.get();
        chilanzarDetail.setHood(hood);

        Optional<Mirrors> byId4 = mirrorsRepo.findById(chilanzarDetailDto.getMirrorsDto());
        Mirrors mirrors = byId4.get();
        chilanzarDetail.setMirrors(mirrors);

        Optional<Roof> byId5 = roofRepo.findById(chilanzarDetailDto.getRoofDto());
        Roof roof = byId5.get();
        chilanzarDetail.setRoof(roof);

        Optional<Seats> byId6 = seatsRepo.findById(chilanzarDetailDto.getSeatsDto());
        Seats seats = byId6.get();
        chilanzarDetail.setSeats(seats);

        Optional<Tires> byId7 = tiresRepo.findById(chilanzarDetailDto.getTiresDto());
        Tires tires = byId7.get();
        chilanzarDetail.setTires(tires);

        Optional<Transmission> byId8 = transmissionRepo.findById(chilanzarDetailDto.getTransmissionDto());
        Transmission transmission = byId8.get();
        chilanzarDetail.setTransmission(transmission);

        Optional<Wheels> byId9 = wheelsRepo.findById(chilanzarDetailDto.getWheelsDto());
        Wheels wheels = byId9.get();
        chilanzarDetail.setWheels(wheels);

        chilanzarDetailRepo.save(chilanzarDetail);
        return new Result("Chilanzar detail information created successfully", true);
    }

    public Result update(ChilanzarDetailDto chilanzarDetailDto, UUID id) {
        Optional<ChilanzarDetail> byId = chilanzarDetailRepo.findById(id);
        if (byId.isPresent()) {
            ChilanzarDetail chilanzarDetail = byId.get();
            chilanzarDetail.setStoreName(chilanzarDetailDto.getStoreName());
            chilanzarDetail.setLongtitute(chilanzarDetailDto.getLongtitute());
            chilanzarDetail.setLatitute(chilanzarDetailDto.getLatitute());

            Optional<Bumper> byIdorg = bumperRepo.findById(chilanzarDetailDto.getBumperDto());
            Bumper bumper = byIdorg.get();
            chilanzarDetail.setBumper(bumper);

            Optional<Door> byId1 = doorRepo.findById(chilanzarDetailDto.getDoorDto());
            Door door = byId1.get();
            chilanzarDetail.setDoor(door);

            Optional<Engine> byId2 = engineRepo.findById(chilanzarDetailDto.getEngineDto());
            Engine engine = byId2.get();
            chilanzarDetail.setEngine(engine);

            Optional<Hood> byId3 = hoodRepo.findById(chilanzarDetailDto.getHoodDto());
            Hood hood = byId3.get();
            chilanzarDetail.setHood(hood);

            Optional<Mirrors> byId4 = mirrorsRepo.findById(chilanzarDetailDto.getMirrorsDto());
            Mirrors mirrors = byId4.get();
            chilanzarDetail.setMirrors(mirrors);

            Optional<Roof> byId5 = roofRepo.findById(chilanzarDetailDto.getRoofDto());
            Roof roof = byId5.get();
            chilanzarDetail.setRoof(roof);

            Optional<Seats> byId6 = seatsRepo.findById(chilanzarDetailDto.getSeatsDto());
            Seats seats = byId6.get();
            chilanzarDetail.setSeats(seats);

            Optional<Tires> byId7 = tiresRepo.findById(chilanzarDetailDto.getTiresDto());
            Tires tires = byId7.get();
            chilanzarDetail.setTires(tires);

            Optional<Transmission> byId8 = transmissionRepo.findById(chilanzarDetailDto.getTransmissionDto());
            Transmission transmission = byId8.get();
            chilanzarDetail.setTransmission(transmission);

            Optional<Wheels> byId9 = wheelsRepo.findById(chilanzarDetailDto.getWheelsDto());
            Wheels wheels = byId9.get();
            chilanzarDetail.setWheels(wheels);

            chilanzarDetailRepo.save(chilanzarDetail);
            return new Result("Chilanzar detail information updated successfully", true);
        }
        return new Result("Chilanzar detail information not found", false);
    }

    public Result delete(UUID id) {
        Optional<ChilanzarDetail> byId = chilanzarDetailRepo.findById(id);
        if (byId.isPresent()) {
            chilanzarDetailRepo.deleteById(id);
            return new Result("Chilanzar detail information deleted successfully", true);
        }
        return new Result("Chilanzar detail information not found", false);
    }

}