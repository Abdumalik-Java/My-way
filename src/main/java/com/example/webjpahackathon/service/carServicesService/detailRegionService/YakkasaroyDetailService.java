package com.example.webjpahackathon.service.carServicesService.detailRegionService;

import com.example.webjpahackathon.dto.carServicesDto.detailRegionDto.YakkasaroyDetailDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.*;
import com.example.webjpahackathon.model.carServices.detailRegion.YakkasaroyDetail;
import com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo.YakkasaroyDetailRepo;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class YakkasaroyDetailService {

    @Autowired
    YakkasaroyDetailRepo yakkasaroyDetailRepo;

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

    public List<YakkasaroyDetail> readAllYakkasaroyDetails() {
        return yakkasaroyDetailRepo.findAll();
    }

    public YakkasaroyDetail readYakkasaroyDetail(UUID id) {
        return yakkasaroyDetailRepo.findById(id).get();
    }

    public YakkasaroyDetail readByName(String name) {
        return yakkasaroyDetailRepo.findByStoreName(name).get();
    }

    public Result create(YakkasaroyDetailDto yakkasaroyDetailDto) {
        YakkasaroyDetail yakkasaroyDetail = new YakkasaroyDetail();
        yakkasaroyDetail.setStoreName(yakkasaroyDetailDto.getStoreName());
        yakkasaroyDetail.setLatitute(yakkasaroyDetailDto.getLatitute());
        yakkasaroyDetail.setLongtitute(yakkasaroyDetailDto.getLongtitute());

        Optional<Bumper> byId = bumperRepo.findById(yakkasaroyDetailDto.getBumperDto());
        Bumper bumper = byId.get();
        yakkasaroyDetail.setBumper(bumper);

        Optional<Door> byId1 = doorRepo.findById(yakkasaroyDetailDto.getDoorDto());
        Door door = byId1.get();
        yakkasaroyDetail.setDoor(door);

        Optional<Engine> byId2 = engineRepo.findById(yakkasaroyDetailDto.getEngineDto());
        Engine engine = byId2.get();
        yakkasaroyDetail.setEngine(engine);

        Optional<Hood> byId3 = hoodRepo.findById(yakkasaroyDetailDto.getHoodDto());
        Hood hood = byId3.get();
        yakkasaroyDetail.setHood(hood);

        Optional<Mirrors> byId4 = mirrorsRepo.findById(yakkasaroyDetailDto.getMirrorsDto());
        Mirrors mirrors = byId4.get();
        yakkasaroyDetail.setMirrors(mirrors);

        Optional<Roof> byId5 = roofRepo.findById(yakkasaroyDetailDto.getRoofDto());
        Roof roof = byId5.get();
        yakkasaroyDetail.setRoof(roof);

        Optional<Seats> byId6 = seatsRepo.findById(yakkasaroyDetailDto.getSeatsDto());
        Seats seats = byId6.get();
        yakkasaroyDetail.setSeats(seats);

        Optional<Tires> byId7 = tiresRepo.findById(yakkasaroyDetailDto.getTiresDto());
        Tires tires = byId7.get();
        yakkasaroyDetail.setTires(tires);

        Optional<Transmission> byId8 = transmissionRepo.findById(yakkasaroyDetailDto.getTransmissionDto());
        Transmission transmission = byId8.get();
        yakkasaroyDetail.setTransmission(transmission);

        Optional<Wheels> byId9 = wheelsRepo.findById(yakkasaroyDetailDto.getWheelsDto());
        Wheels wheels = byId9.get();
        yakkasaroyDetail.setWheels(wheels);

        yakkasaroyDetailRepo.save(yakkasaroyDetail);
        return new Result("Yakkasaroy information created successfully", true);
    }

    public Result update(YakkasaroyDetailDto yakkasaroyDetailDto, UUID id) {
        Optional<YakkasaroyDetail> byId = yakkasaroyDetailRepo.findById(id);
        if (byId.isPresent()) {
            YakkasaroyDetail yakkasaroyDetail = byId.get();
            yakkasaroyDetail.setStoreName(yakkasaroyDetailDto.getStoreName());
            yakkasaroyDetail.setLatitute(yakkasaroyDetailDto.getLatitute());
            yakkasaroyDetail.setLongtitute(yakkasaroyDetailDto.getLongtitute());

            Optional<Bumper> byIdorg = bumperRepo.findById(yakkasaroyDetailDto.getBumperDto());
            Bumper bumper = byIdorg.get();
            yakkasaroyDetail.setBumper(bumper);

            Optional<Door> byId1 = doorRepo.findById(yakkasaroyDetailDto.getDoorDto());
            Door door = byId1.get();
            yakkasaroyDetail.setDoor(door);

            Optional<Engine> byId2 = engineRepo.findById(yakkasaroyDetailDto.getEngineDto());
            Engine engine = byId2.get();
            yakkasaroyDetail.setEngine(engine);

            Optional<Hood> byId3 = hoodRepo.findById(yakkasaroyDetailDto.getHoodDto());
            Hood hood = byId3.get();
            yakkasaroyDetail.setHood(hood);

            Optional<Mirrors> byId4 = mirrorsRepo.findById(yakkasaroyDetailDto.getMirrorsDto());
            Mirrors mirrors = byId4.get();
            yakkasaroyDetail.setMirrors(mirrors);

            Optional<Roof> byId5 = roofRepo.findById(yakkasaroyDetailDto.getRoofDto());
            Roof roof = byId5.get();
            yakkasaroyDetail.setRoof(roof);

            Optional<Seats> byId6 = seatsRepo.findById(yakkasaroyDetailDto.getSeatsDto());
            Seats seats = byId6.get();
            yakkasaroyDetail.setSeats(seats);

            Optional<Tires> byId7 = tiresRepo.findById(yakkasaroyDetailDto.getTiresDto());
            Tires tires = byId7.get();
            yakkasaroyDetail.setTires(tires);

            Optional<Transmission> byId8 = transmissionRepo.findById(yakkasaroyDetailDto.getTransmissionDto());
            Transmission transmission = byId8.get();
            yakkasaroyDetail.setTransmission(transmission);

            Optional<Wheels> byId9 = wheelsRepo.findById(yakkasaroyDetailDto.getWheelsDto());
            Wheels wheels = byId9.get();
            yakkasaroyDetail.setWheels(wheels);

            yakkasaroyDetailRepo.save(yakkasaroyDetail);
            return new Result("Yakkasaroy information updated successfully", true);
        }
        return new Result("Yakkasaroy information not found", false);
    }

    public Result delete(UUID id) {
        Optional<YakkasaroyDetail> byId = yakkasaroyDetailRepo.findById(id);
        if (byId.isPresent()) {
            yakkasaroyDetailRepo.deleteById(id);
            return new Result("Yakkasaroy information deleted successfully", true);
        }
        return new Result("Yakkasaroy information not found", false);
    }

}