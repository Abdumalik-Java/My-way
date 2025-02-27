package com.example.webjpahackathon.service.carServicesService.detailRegionService;

import com.example.webjpahackathon.dto.carServicesDto.detailRegionDto.YunusobodDetailDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.*;
import com.example.webjpahackathon.model.carServices.detailRegion.YunusobodDetail;
import com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo.YunusobodDetailRepo;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class YunusobodDetailService {

    @Autowired
    YunusobodDetailRepo yunusobodDetailRepo;

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

    public List<YunusobodDetail> readAll() {
        return yunusobodDetailRepo.findAll();
    }

    public YunusobodDetail readOne(UUID id) {
        return yunusobodDetailRepo.findById(id).get();
    }

    public YunusobodDetail readByName(String name) {
        return yunusobodDetailRepo.findByStoreName(name).get();
    }

    public Result create(YunusobodDetailDto yunusobodDetailDto) {
        YunusobodDetail yunusobodDetail = new YunusobodDetail();
        yunusobodDetail.setStoreName(yunusobodDetailDto.getStoreName());
        yunusobodDetail.setLatitute(yunusobodDetailDto.getLatitute());
        yunusobodDetail.setLongtitute(yunusobodDetailDto.getLongtitute());

        Optional<Bumper> byId = bumperRepo.findById(yunusobodDetailDto.getBumperDto());
        Bumper bumper = byId.get();
        yunusobodDetail.setBumper(bumper);

        Optional<Door> byId1 = doorRepo.findById(yunusobodDetailDto.getDoorDto());
        Door door = byId1.get();
        yunusobodDetail.setDoor(door);

        Optional<Engine> byId2 = engineRepo.findById(yunusobodDetailDto.getEngineDto());
        Engine engine = byId2.get();
        yunusobodDetail.setEngine(engine);

        Optional<Hood> byId3 = hoodRepo.findById(yunusobodDetailDto.getHoodDto());
        Hood hood = byId3.get();
        yunusobodDetail.setHood(hood);

        Optional<Mirrors> byId4 = mirrorsRepo.findById(yunusobodDetailDto.getMirrorsDto());
        Mirrors mirrors = byId4.get();
        yunusobodDetail.setMirrors(mirrors);

        Optional<Roof> byId5 = roofRepo.findById(yunusobodDetailDto.getRoofDto());
        Roof roof = byId5.get();
        yunusobodDetail.setRoof(roof);

        Optional<Seats> byId6 = seatsRepo.findById(yunusobodDetailDto.getSeatsDto());
        Seats seats = byId6.get();
        yunusobodDetail.setSeats(seats);

        Optional<Tires> byId7 = tiresRepo.findById(yunusobodDetailDto.getTiresDto());
        Tires tires = byId7.get();
        yunusobodDetail.setTires(tires);

        Optional<Transmission> byId8 = transmissionRepo.findById(yunusobodDetailDto.getTransmissionDto());
        Transmission transmission = byId8.get();
        yunusobodDetail.setTransmission(transmission);

        Optional<Wheels> byId9 = wheelsRepo.findById(yunusobodDetailDto.getWheelsDto());
        Wheels wheels = byId9.get();
        yunusobodDetail.setWheels(wheels);

        yunusobodDetailRepo.save(yunusobodDetail);
        return new Result("Yunusobod information created successfully", true);
    }

    public Result update(YunusobodDetailDto yunusobodDetailDto, UUID id) {
        Optional<YunusobodDetail> byId = yunusobodDetailRepo.findById(id);
        if (byId.isPresent()) {
            YunusobodDetail yunusobodDetail = byId.get();
            yunusobodDetail.setStoreName(yunusobodDetailDto.getStoreName());
            yunusobodDetail.setLatitute(yunusobodDetailDto.getLatitute());
            yunusobodDetail.setLongtitute(yunusobodDetailDto.getLongtitute());

            Optional<Bumper> byIdorg = bumperRepo.findById(yunusobodDetailDto.getBumperDto());
            Bumper bumper = byIdorg.get();
            yunusobodDetail.setBumper(bumper);

            Optional<Door> byId1 = doorRepo.findById(yunusobodDetailDto.getDoorDto());
            Door door = byId1.get();
            yunusobodDetail.setDoor(door);

            Optional<Engine> byId2 = engineRepo.findById(yunusobodDetailDto.getEngineDto());
            Engine engine = byId2.get();
            yunusobodDetail.setEngine(engine);

            Optional<Hood> byId3 = hoodRepo.findById(yunusobodDetailDto.getHoodDto());
            Hood hood = byId3.get();
            yunusobodDetail.setHood(hood);

            Optional<Mirrors> byId4 = mirrorsRepo.findById(yunusobodDetailDto.getMirrorsDto());
            Mirrors mirrors = byId4.get();
            yunusobodDetail.setMirrors(mirrors);

            Optional<Roof> byId5 = roofRepo.findById(yunusobodDetailDto.getRoofDto());
            Roof roof = byId5.get();
            yunusobodDetail.setRoof(roof);

            Optional<Seats> byId6 = seatsRepo.findById(yunusobodDetailDto.getSeatsDto());
            Seats seats = byId6.get();
            yunusobodDetail.setSeats(seats);

            Optional<Tires> byId7 = tiresRepo.findById(yunusobodDetailDto.getTiresDto());
            Tires tires = byId7.get();
            yunusobodDetail.setTires(tires);

            Optional<Transmission> byId8 = transmissionRepo.findById(yunusobodDetailDto.getTransmissionDto());
            Transmission transmission = byId8.get();
            yunusobodDetail.setTransmission(transmission);

            Optional<Wheels> byId9 = wheelsRepo.findById(yunusobodDetailDto.getWheelsDto());
            Wheels wheels = byId9.get();
            yunusobodDetail.setWheels(wheels);

            yunusobodDetailRepo.save(yunusobodDetail);
            return new Result("Yunusobod information updated successfully", true);
        }
        return new Result("Yunusobod information not found", false);
    }

    public Result delete(UUID id) {
        Optional<YunusobodDetail> byId = yunusobodDetailRepo.findById(id);
        if (byId.isPresent()) {
            yunusobodDetailRepo.deleteById(id);
            return new Result("Yunusobod information deleted successfully", true);
        }
        return new Result("Yunusobod information not found", false);
    }

}