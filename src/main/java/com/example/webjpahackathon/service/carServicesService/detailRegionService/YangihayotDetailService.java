package com.example.webjpahackathon.service.carServicesService.detailRegionService;

import com.example.webjpahackathon.dto.carServicesDto.detailRegionDto.YangihayotDetailDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.*;
import com.example.webjpahackathon.model.carServices.detailRegion.YangihayotDetail;
import com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo.YangihayotDetailRepo;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class YangihayotDetailService {

    @Autowired
    YangihayotDetailRepo yangihayotDetailRepo;

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

    public List<YangihayotDetail> readAllYangihayotDetails() {
        return yangihayotDetailRepo.findAll();
    }

    public YangihayotDetail readYangihayotDetail(UUID id) {
        return yangihayotDetailRepo.findById(id).get();
    }

    public YangihayotDetail readByName(String name) {
        return yangihayotDetailRepo.findByStoreName(name).get();
    }

    public Result create(YangihayotDetailDto yangihayotDetailDto) {
        YangihayotDetail yangihayotDetail = new YangihayotDetail();
        yangihayotDetail.setStoreName(yangihayotDetailDto.getStoreName());
        yangihayotDetail.setLatitute(yangihayotDetailDto.getLatitute());
        yangihayotDetail.setLongtitute(yangihayotDetailDto.getLongtitute());

        Optional<Bumper> byId = bumperRepo.findById(yangihayotDetailDto.getBumperDto());
        Bumper bumper = byId.get();
        yangihayotDetail.setBumper(bumper);

        Optional<Door> byId1 = doorRepo.findById(yangihayotDetailDto.getDoorDto());
        Door door = byId1.get();
        yangihayotDetail.setDoor(door);

        Optional<Engine> byId2 = engineRepo.findById(yangihayotDetailDto.getEngineDto());
        Engine engine = byId2.get();
        yangihayotDetail.setEngine(engine);

        Optional<Hood> byId3 = hoodRepo.findById(yangihayotDetailDto.getHoodDto());
        Hood hood = byId3.get();
        yangihayotDetail.setHood(hood);

        Optional<Mirrors> byId4 = mirrorsRepo.findById(yangihayotDetailDto.getMirrorsDto());
        Mirrors mirrors = byId4.get();
        yangihayotDetail.setMirrors(mirrors);

        Optional<Roof> byId5 = roofRepo.findById(yangihayotDetailDto.getRoofDto());
        Roof roof = byId5.get();
        yangihayotDetail.setRoof(roof);

        Optional<Seats> byId6 = seatsRepo.findById(yangihayotDetailDto.getSeatsDto());
        Seats seats = byId6.get();
        yangihayotDetail.setSeats(seats);

        Optional<Tires> byId7 = tiresRepo.findById(yangihayotDetailDto.getTiresDto());
        Tires tires = byId7.get();
        yangihayotDetail.setTires(tires);

        Optional<Transmission> byId8 = transmissionRepo.findById(yangihayotDetailDto.getTransmissionDto());
        Transmission transmission = byId8.get();
        yangihayotDetail.setTransmission(transmission);

        Optional<Wheels> byId9 = wheelsRepo.findById(yangihayotDetailDto.getWheelsDto());
        Wheels wheels = byId9.get();
        yangihayotDetail.setWheels(wheels);

        yangihayotDetailRepo.save(yangihayotDetail);
        return new Result("Yangihayot information created successfully", true);
    }

    public Result update(YangihayotDetailDto yangihayotDetailDto, UUID id) {
        Optional<YangihayotDetail> byId = yangihayotDetailRepo.findById(id);
        if (byId.isPresent()) {
            YangihayotDetail yangihayotDetail = byId.get();
            yangihayotDetail.setStoreName(yangihayotDetailDto.getStoreName());
            yangihayotDetail.setLatitute(yangihayotDetailDto.getLatitute());
            yangihayotDetail.setLongtitute(yangihayotDetailDto.getLongtitute());

            Optional<Bumper> byIdorg = bumperRepo.findById(yangihayotDetailDto.getBumperDto());
            Bumper bumper = byIdorg.get();
            yangihayotDetail.setBumper(bumper);

            Optional<Door> byId1 = doorRepo.findById(yangihayotDetailDto.getDoorDto());
            Door door = byId1.get();
            yangihayotDetail.setDoor(door);

            Optional<Engine> byId2 = engineRepo.findById(yangihayotDetailDto.getEngineDto());
            Engine engine = byId2.get();
            yangihayotDetail.setEngine(engine);

            Optional<Hood> byId3 = hoodRepo.findById(yangihayotDetailDto.getHoodDto());
            Hood hood = byId3.get();
            yangihayotDetail.setHood(hood);

            Optional<Mirrors> byId4 = mirrorsRepo.findById(yangihayotDetailDto.getMirrorsDto());
            Mirrors mirrors = byId4.get();
            yangihayotDetail.setMirrors(mirrors);

            Optional<Roof> byId5 = roofRepo.findById(yangihayotDetailDto.getRoofDto());
            Roof roof = byId5.get();
            yangihayotDetail.setRoof(roof);

            Optional<Seats> byId6 = seatsRepo.findById(yangihayotDetailDto.getSeatsDto());
            Seats seats = byId6.get();
            yangihayotDetail.setSeats(seats);

            Optional<Tires> byId7 = tiresRepo.findById(yangihayotDetailDto.getTiresDto());
            Tires tires = byId7.get();
            yangihayotDetail.setTires(tires);

            Optional<Transmission> byId8 = transmissionRepo.findById(yangihayotDetailDto.getTransmissionDto());
            Transmission transmission = byId8.get();
            yangihayotDetail.setTransmission(transmission);

            Optional<Wheels> byId9 = wheelsRepo.findById(yangihayotDetailDto.getWheelsDto());
            Wheels wheels = byId9.get();
            yangihayotDetail.setWheels(wheels);

            yangihayotDetailRepo.save(yangihayotDetail);
            return new Result("Yangihayot information updated successfully", true);
        }
        return new Result("Yangihayot information not found", false);
    }

    public Result delete(UUID id) {
        Optional<YangihayotDetail> byId = yangihayotDetailRepo.findById(id);
        if (byId.isPresent()) {
            yangihayotDetailRepo.deleteById(id);
            return new Result("Yangihayot information deleted successfully", true);
        }
        return new Result("Yangihayot information not found", false);
    }

}