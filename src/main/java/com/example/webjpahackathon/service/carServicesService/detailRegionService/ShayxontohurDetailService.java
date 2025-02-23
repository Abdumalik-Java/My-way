package com.example.webjpahackathon.service.carServicesService.detailRegionService;

import com.example.webjpahackathon.dto.carServicesDto.detailRegionDto.ShayxontohurDetailDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.*;
import com.example.webjpahackathon.model.carServices.detailRegion.ShayxontohurDetail;
import com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo.ShayxontohurDetailRepo;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShayxontohurDetailService {

    @Autowired
    ShayxontohurDetailRepo shayxontohurDetailRepo;

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

    public List<ShayxontohurDetail> readAllShayxontohurDetails() {
        return shayxontohurDetailRepo.findAll();
    }

    public ShayxontohurDetail readShayxontohurDetailById(UUID id) {
        return shayxontohurDetailRepo.findById(id).get();
    }

    public ShayxontohurDetail readShayxontohurDetailByName(String name) {
        return shayxontohurDetailRepo.findByStoreName(name).get();
    }

    public Result createShayxontohurDetail(ShayxontohurDetailDto shayxontohurDetailDto) {
        ShayxontohurDetail shayxontohurDetail = new ShayxontohurDetail();
        shayxontohurDetail.setStoreName(shayxontohurDetailDto.getStoreName());
        shayxontohurDetail.setLatitute(shayxontohurDetailDto.getLatitute());
        shayxontohurDetail.setLongtitute(shayxontohurDetailDto.getLongtitute());

        Optional<Bumper> byId = bumperRepo.findById(shayxontohurDetailDto.getBumperDto());
        Bumper bumper = byId.get();
        shayxontohurDetail.setBumper(bumper);

        Optional<Door> byId1 = doorRepo.findById(shayxontohurDetailDto.getDoorDto());
        Door door = byId1.get();
        shayxontohurDetail.setDoor(door);

        Optional<Engine> byId2 = engineRepo.findById(shayxontohurDetailDto.getEngineDto());
        Engine engine = byId2.get();
        shayxontohurDetail.setEngine(engine);

        Optional<Hood> byId3 = hoodRepo.findById(shayxontohurDetailDto.getHoodDto());
        Hood hood = byId3.get();
        shayxontohurDetail.setHood(hood);

        Optional<Roof> byId4 = roofRepo.findById(shayxontohurDetailDto.getRoofDto());
        Roof roof = byId4.get();
        shayxontohurDetail.setRoof(roof);

        Optional<Mirrors> byId5 = mirrorsRepo.findById(shayxontohurDetailDto.getMirrorsDto());
        Mirrors mirrors = byId5.get();
        shayxontohurDetail.setMirrors(mirrors);

        Optional<Seats> byId6 = seatsRepo.findById(shayxontohurDetailDto.getSeatsDto());
        Seats seats = byId6.get();
        shayxontohurDetail.setSeats(seats);

        Optional<Tires> byId7 = tiresRepo.findById(shayxontohurDetailDto.getTiresDto());
        Tires tires = byId7.get();
        shayxontohurDetail.setTires(tires);

        Optional<Transmission> byId8 = transmissionRepo.findById(shayxontohurDetailDto.getTransmissionDto());
        Transmission transmission = byId8.get();
        shayxontohurDetail.setTransmission(transmission);

        Optional<Wheels> byId9 = wheelsRepo.findById(shayxontohurDetailDto.getWheelsDto());
        Wheels wheels = byId9.get();
        shayxontohurDetail.setWheels(wheels);

        shayxontohurDetailRepo.save(shayxontohurDetail);
        return new Result("Shayxontohur detail information found", true);
    }

    public Result update(ShayxontohurDetailDto shayxontohurDetailDto, UUID id) {
        Optional<ShayxontohurDetail> byId = shayxontohurDetailRepo.findById(id);
        if (byId.isPresent()) {
            ShayxontohurDetail shayxontohurDetail = byId.get();
            Optional<Bumper> byIdorg = bumperRepo.findById(shayxontohurDetailDto.getBumperDto());
            Bumper bumper = byIdorg.get();
            shayxontohurDetail.setBumper(bumper);

            Optional<Door> byId1 = doorRepo.findById(shayxontohurDetailDto.getDoorDto());
            Door door = byId1.get();
            shayxontohurDetail.setDoor(door);

            Optional<Engine> byId2 = engineRepo.findById(shayxontohurDetailDto.getEngineDto());
            Engine engine = byId2.get();
            shayxontohurDetail.setEngine(engine);

            Optional<Hood> byId3 = hoodRepo.findById(shayxontohurDetailDto.getHoodDto());
            Hood hood = byId3.get();
            shayxontohurDetail.setHood(hood);

            Optional<Roof> byId4 = roofRepo.findById(shayxontohurDetailDto.getRoofDto());
            Roof roof = byId4.get();
            shayxontohurDetail.setRoof(roof);

            Optional<Mirrors> byId5 = mirrorsRepo.findById(shayxontohurDetailDto.getMirrorsDto());
            Mirrors mirrors = byId5.get();
            shayxontohurDetail.setMirrors(mirrors);

            Optional<Seats> byId6 = seatsRepo.findById(shayxontohurDetailDto.getSeatsDto());
            Seats seats = byId6.get();
            shayxontohurDetail.setSeats(seats);

            Optional<Tires> byId7 = tiresRepo.findById(shayxontohurDetailDto.getTiresDto());
            Tires tires = byId7.get();
            shayxontohurDetail.setTires(tires);

            Optional<Transmission> byId8 = transmissionRepo.findById(shayxontohurDetailDto.getTransmissionDto());
            Transmission transmission = byId8.get();
            shayxontohurDetail.setTransmission(transmission);

            Optional<Wheels> byId9 = wheelsRepo.findById(shayxontohurDetailDto.getWheelsDto());
            Wheels wheels = byId9.get();
            shayxontohurDetail.setWheels(wheels);

            shayxontohurDetailRepo.save(shayxontohurDetail);
            return new Result("Shayxontohur detail information found", true);
        }
        return new Result("Shayxontohur detail information not found", false);
    }

    public Result delete(UUID id) {
        Optional<ShayxontohurDetail> byId = shayxontohurDetailRepo.findById(id);
        if (byId.isPresent()) {
            shayxontohurDetailRepo.deleteById(id);
            return new Result("Shayxontohur detail information deleted", true);
        }
        return new Result("Shayxontohur detail information not found", false);
    }

}