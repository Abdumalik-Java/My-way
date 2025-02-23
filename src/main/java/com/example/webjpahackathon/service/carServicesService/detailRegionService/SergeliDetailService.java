package com.example.webjpahackathon.service.carServicesService.detailRegionService;

import com.example.webjpahackathon.dto.carServicesDto.detailRegionDto.SergeliDetailDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.*;
import com.example.webjpahackathon.model.carServices.detailRegion.SergeliDetail;
import com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo.SergeliDetailRepo;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SergeliDetailService {

    @Autowired
    SergeliDetailRepo sergeliDetailRepo;

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

    public List<SergeliDetail> readAllOlmazor() {
        return sergeliDetailRepo.findAll();
    }

    public SergeliDetail readSergeliDetailById(UUID id) {
        return sergeliDetailRepo.findById(id).get();
    }

    public SergeliDetail readSergeliDetailByName(String name) {
        return sergeliDetailRepo.findByStoreName(name).get();
    }

    public Result createSergeliDetail(SergeliDetailDto sergeliDetailDto) {
        SergeliDetail sergeliDetail = new SergeliDetail();
        sergeliDetail.setStoreName(sergeliDetailDto.getStoreName());
        sergeliDetail.setLatitute(sergeliDetailDto.getLatitute());
        sergeliDetail.setLongtitute(sergeliDetailDto.getLongtitute());

        Optional<Bumper> byId = bumperRepo.findById(sergeliDetailDto.getBumperDto());
        Bumper bumper = byId.get();
        sergeliDetail.setBumper(bumper);

        Optional<Door> byId1 = doorRepo.findById(sergeliDetailDto.getDoorDto());
        Door door = byId1.get();
        sergeliDetail.setDoor(door);

        Optional<Engine> byId2 = engineRepo.findById(sergeliDetailDto.getEngineDto());
        Engine engine = byId2.get();
        sergeliDetail.setEngine(engine);

        Optional<Hood> byId3 = hoodRepo.findById(sergeliDetailDto.getHoodDto());
        Hood hood = byId3.get();
        sergeliDetail.setHood(hood);

        Optional<Roof> byId4 = roofRepo.findById(sergeliDetailDto.getRoofDto());
        Roof roof = byId4.get();
        sergeliDetail.setRoof(roof);

        Optional<Mirrors> byId5 = mirrorsRepo.findById(sergeliDetailDto.getMirrorsDto());
        Mirrors mirrors = byId5.get();
        sergeliDetail.setMirrors(mirrors);

        Optional<Seats> byId6 = seatsRepo.findById(sergeliDetailDto.getSeatsDto());
        Seats seats = byId6.get();
        sergeliDetail.setSeats(seats);

        Optional<Tires> byId7 = tiresRepo.findById(sergeliDetailDto.getTiresDto());
        Tires tires = byId7.get();
        sergeliDetail.setTires(tires);

        Optional<Transmission> byId8 = transmissionRepo.findById(sergeliDetailDto.getTransmissionDto());
        Transmission transmission = byId8.get();
        sergeliDetail.setTransmission(transmission);

        Optional<Wheels> byId9 = wheelsRepo.findById(sergeliDetailDto.getWheelsDto());
        Wheels wheels = byId9.get();
        sergeliDetail.setWheels(wheels);

        sergeliDetailRepo.save(sergeliDetail);
        return new Result("Sergeli detail information created successfully", true);
    }

    public Result update(SergeliDetailDto sergeliDetailDto, UUID id) {
        Optional<SergeliDetail> byId = sergeliDetailRepo.findById(id);
        if (byId.isPresent()) {
            SergeliDetail sergeliDetail = byId.get();
            sergeliDetail.setStoreName(sergeliDetailDto.getStoreName());
            sergeliDetail.setLatitute(sergeliDetailDto.getLatitute());
            sergeliDetail.setLongtitute(sergeliDetailDto.getLongtitute());

            Optional<Bumper> byIdorg = bumperRepo.findById(sergeliDetailDto.getBumperDto());
            Bumper bumper = byIdorg.get();
            sergeliDetail.setBumper(bumper);

            Optional<Door> byId1 = doorRepo.findById(sergeliDetailDto.getDoorDto());
            Door door = byId1.get();
            sergeliDetail.setDoor(door);

            Optional<Engine> byId2 = engineRepo.findById(sergeliDetailDto.getEngineDto());
            Engine engine = byId2.get();
            sergeliDetail.setEngine(engine);

            Optional<Hood> byId3 = hoodRepo.findById(sergeliDetailDto.getHoodDto());
            Hood hood = byId3.get();
            sergeliDetail.setHood(hood);

            Optional<Roof> byId4 = roofRepo.findById(sergeliDetailDto.getRoofDto());
            Roof roof = byId4.get();
            sergeliDetail.setRoof(roof);

            Optional<Mirrors> byId5 = mirrorsRepo.findById(sergeliDetailDto.getMirrorsDto());
            Mirrors mirrors = byId5.get();
            sergeliDetail.setMirrors(mirrors);

            Optional<Seats> byId6 = seatsRepo.findById(sergeliDetailDto.getSeatsDto());
            Seats seats = byId6.get();
            sergeliDetail.setSeats(seats);

            Optional<Tires> byId7 = tiresRepo.findById(sergeliDetailDto.getTiresDto());
            Tires tires = byId7.get();
            sergeliDetail.setTires(tires);

            Optional<Transmission> byId8 = transmissionRepo.findById(sergeliDetailDto.getTransmissionDto());
            Transmission transmission = byId8.get();
            sergeliDetail.setTransmission(transmission);

            Optional<Wheels> byId9 = wheelsRepo.findById(sergeliDetailDto.getWheelsDto());
            Wheels wheels = byId9.get();
            sergeliDetail.setWheels(wheels);

            sergeliDetailRepo.save(sergeliDetail);
            return new Result("Sergeli detail information updated successfully", true);
        }
        return new Result("Sergeli detail information not found", false);
    }

    public Result delete(UUID id) {
        Optional<SergeliDetail> byId = sergeliDetailRepo.findById(id);
        if (byId.isPresent()) {
            sergeliDetailRepo.deleteById(id);
            return new Result("Sergeli detail information deleted successfully", true);
        }
        return new Result("Sergeli detail information not found", false);
    }

}