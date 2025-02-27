package com.example.webjpahackathon.service.carServicesService.detailRegionService;

import com.example.webjpahackathon.dto.carServicesDto.detailRegionDto.YashnabodDetailDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.*;
import com.example.webjpahackathon.model.carServices.detailRegion.YashnabodDetail;
import com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo.YashnabodDetailRepo;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class YashnabodDetailService {

    @Autowired
    YashnabodDetailRepo yashnabodDetailRepo;

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

    public List<YashnabodDetail> readAllYashnabodDetails() {
        return yashnabodDetailRepo.findAll();
    }

    public YashnabodDetail readById(UUID id) {
        return yashnabodDetailRepo.findById(id).get();
    }

    public YashnabodDetail readByName(String name) {
        return yashnabodDetailRepo.findByStoreName(name).get();
    }

    public Result create(YashnabodDetailDto yashnabodDetailDto) {
        YashnabodDetail yashnabodDetail = new YashnabodDetail();
        yashnabodDetail.setStoreName(yashnabodDetailDto.getStoreName());
        yashnabodDetail.setLatitute(yashnabodDetailDto.getLatitute());
        yashnabodDetail.setLongtitute(yashnabodDetailDto.getLongtitute());

        Optional<Bumper> byId = bumperRepo.findById(yashnabodDetailDto.getBumperDto());
        Bumper bumper = byId.get();
        yashnabodDetail.setBumper(bumper);

        Optional<Door> byId1 = doorRepo.findById(yashnabodDetailDto.getDoorDto());
        Door door = byId1.get();
        yashnabodDetail.setDoor(door);

        Optional<Engine> byId2 = engineRepo.findById(yashnabodDetailDto.getEngineDto());
        Engine engine = byId2.get();
        yashnabodDetail.setEngine(engine);

        Optional<Hood> byId3 = hoodRepo.findById(yashnabodDetailDto.getHoodDto());
        Hood hood = byId3.get();
        yashnabodDetail.setHood(hood);

        Optional<Mirrors> byId4 = mirrorsRepo.findById(yashnabodDetailDto.getMirrorsDto());
        Mirrors mirrors = byId4.get();
        yashnabodDetail.setMirrors(mirrors);

        Optional<Roof> byId5 = roofRepo.findById(yashnabodDetailDto.getRoofDto());
        Roof roof = byId5.get();
        yashnabodDetail.setRoof(roof);

        Optional<Seats> byId6 = seatsRepo.findById(yashnabodDetailDto.getSeatsDto());
        Seats seats = byId6.get();
        yashnabodDetail.setSeats(seats);

        Optional<Tires> byId7 = tiresRepo.findById(yashnabodDetailDto.getTiresDto());
        Tires tires = byId7.get();
        yashnabodDetail.setTires(tires);

        Optional<Transmission> byId8 = transmissionRepo.findById(yashnabodDetailDto.getTransmissionDto());
        Transmission transmission = byId8.get();
        yashnabodDetail.setTransmission(transmission);

        Optional<Wheels> byId9 = wheelsRepo.findById(yashnabodDetailDto.getWheelsDto());
        Wheels wheels = byId9.get();
        yashnabodDetail.setWheels(wheels);

        yashnabodDetailRepo.save(yashnabodDetail);
        return new Result("Yashnabod information created successfully", true);
    }

    public Result update(YashnabodDetailDto yashnabodDetailDto, UUID id) {
        Optional<YashnabodDetail> byId = yashnabodDetailRepo.findById(id);
        if (byId.isPresent()) {
            YashnabodDetail yashnabodDetail = byId.get();
            yashnabodDetail.setStoreName(yashnabodDetailDto.getStoreName());
            yashnabodDetail.setLatitute(yashnabodDetailDto.getLatitute());
            yashnabodDetail.setLongtitute(yashnabodDetailDto.getLongtitute());

            Optional<Bumper> byIdorg = bumperRepo.findById(yashnabodDetailDto.getBumperDto());
            Bumper bumper = byIdorg.get();
            yashnabodDetail.setBumper(bumper);

            Optional<Door> byId1 = doorRepo.findById(yashnabodDetailDto.getDoorDto());
            Door door = byId1.get();
            yashnabodDetail.setDoor(door);

            Optional<Engine> byId2 = engineRepo.findById(yashnabodDetailDto.getEngineDto());
            Engine engine = byId2.get();
            yashnabodDetail.setEngine(engine);

            Optional<Hood> byId3 = hoodRepo.findById(yashnabodDetailDto.getHoodDto());
            Hood hood = byId3.get();
            yashnabodDetail.setHood(hood);

            Optional<Mirrors> byId4 = mirrorsRepo.findById(yashnabodDetailDto.getMirrorsDto());
            Mirrors mirrors = byId4.get();
            yashnabodDetail.setMirrors(mirrors);

            Optional<Roof> byId5 = roofRepo.findById(yashnabodDetailDto.getRoofDto());
            Roof roof = byId5.get();
            yashnabodDetail.setRoof(roof);

            Optional<Seats> byId6 = seatsRepo.findById(yashnabodDetailDto.getSeatsDto());
            Seats seats = byId6.get();
            yashnabodDetail.setSeats(seats);

            Optional<Tires> byId7 = tiresRepo.findById(yashnabodDetailDto.getTiresDto());
            Tires tires = byId7.get();
            yashnabodDetail.setTires(tires);

            Optional<Transmission> byId8 = transmissionRepo.findById(yashnabodDetailDto.getTransmissionDto());
            Transmission transmission = byId8.get();
            yashnabodDetail.setTransmission(transmission);

            Optional<Wheels> byId9 = wheelsRepo.findById(yashnabodDetailDto.getWheelsDto());
            Wheels wheels = byId9.get();
            yashnabodDetail.setWheels(wheels);

            yashnabodDetailRepo.save(yashnabodDetail);
            return new Result("Yashnabod information updated successfully", true);
        }
        return new Result("Yashnabod information not found", false);
    }

    public Result delete(UUID id) {
        Optional<YashnabodDetail> byId = yashnabodDetailRepo.findById(id);
        if (byId.isPresent()) {
            yashnabodDetailRepo.deleteById(id);
            return new Result("Yashnabod information deleted successfully", true);
        }
        return new Result("Yashnabod information not found", false);
    }

}