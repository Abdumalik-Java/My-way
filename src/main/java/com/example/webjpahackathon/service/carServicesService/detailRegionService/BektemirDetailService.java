package com.example.webjpahackathon.service.carServicesService.detailRegionService;

import com.example.webjpahackathon.dto.carServicesDto.detailRegionDto.BektemirDetailDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.*;
import com.example.webjpahackathon.model.carServices.detailRegion.BektemirDetail;
import com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo.BektemirDetailRepo;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BektemirDetailService {

    @Autowired
    BektemirDetailRepo bektemirDetailRepo;

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

    public List<BektemirDetail> getBektemirDetails() {
        return bektemirDetailRepo.findAll();
    }

    public BektemirDetail getBektemirDetailById(UUID id) {
        return bektemirDetailRepo.findById(id).get();
    }

    public BektemirDetail getBektemirDetailByName(String name) {
        return bektemirDetailRepo.findByStoreName(name).get();
    }

    public Result createBektemirDetail(BektemirDetailDto bektemirDetailDto) {
        BektemirDetail bektemirDetail = new BektemirDetail();
        bektemirDetail.setStoreName(bektemirDetailDto.getStoreName());
        bektemirDetail.setLongtitute(bektemirDetailDto.getLongtitute());
        bektemirDetail.setLatitute(bektemirDetailDto.getLatitute());

        Optional<Bumper> byId = bumperRepo.findById(bektemirDetailDto.getBumperDto());
        Bumper bumper = byId.get();
        bektemirDetail.setBumper(bumper);

        Optional<Door> byId1 = doorRepo.findById(bektemirDetailDto.getDoorDto());
        Door door = byId1.get();
        bektemirDetail.setDoor(door);

        Optional<Engine> byId2 = engineRepo.findById(bektemirDetailDto.getEngineDto());
        Engine engine = byId2.get();
        bektemirDetail.setEngine(engine);

        Optional<Hood> byId3 = hoodRepo.findById(bektemirDetailDto.getHoodDto());
        Hood hood = byId3.get();
        bektemirDetail.setHood(hood);

        Optional<Mirrors> byId4 = mirrorsRepo.findById(bektemirDetailDto.getMirrorsDto());
        Mirrors mirrors = byId4.get();
        bektemirDetail.setMirrors(mirrors);

        Optional<Roof> byId5 = roofRepo.findById(bektemirDetailDto.getRoofDto());
        Roof roof = byId5.get();
        bektemirDetail.setRoof(roof);

        Optional<Seats> byId6 = seatsRepo.findById(bektemirDetailDto.getSeatsDto());
        Seats seats = byId6.get();
        bektemirDetail.setSeats(seats);

        Optional<Tires> byId7 = tiresRepo.findById(bektemirDetailDto.getTiresDto());
        Tires tires = byId7.get();
        bektemirDetail.setTires(tires);

        Optional<Transmission> byId8 = transmissionRepo.findById(bektemirDetailDto.getTransmissionDto());
        Transmission transmission = byId8.get();
        bektemirDetail.setTransmission(transmission);

        Optional<Wheels> byId9 = wheelsRepo.findById(bektemirDetailDto.getWheelsDto());
        Wheels wheels = byId9.get();
        bektemirDetail.setWheels(wheels);

        bektemirDetailRepo.save(bektemirDetail);
        return new Result("Bektemir detail information created successfully", true);
    }

    public Result update(BektemirDetailDto bektemirDetailDto, UUID id) {
        Optional<BektemirDetail> byId = bektemirDetailRepo.findById(id);
        if (byId.isPresent()) {
            BektemirDetail bektemirDetail = byId.get();
            bektemirDetail.setStoreName(bektemirDetailDto.getStoreName());
            bektemirDetail.setLongtitute(bektemirDetailDto.getLongtitute());
            bektemirDetail.setLatitute(bektemirDetailDto.getLatitute());

            Optional<Bumper> byIdorg = bumperRepo.findById(bektemirDetailDto.getBumperDto());
            Bumper bumper = byIdorg.get();
            bektemirDetail.setBumper(bumper);

            Optional<Door> byId1 = doorRepo.findById(bektemirDetailDto.getDoorDto());
            Door door = byId1.get();
            bektemirDetail.setDoor(door);

            Optional<Engine> byId2 = engineRepo.findById(bektemirDetailDto.getEngineDto());
            Engine engine = byId2.get();
            bektemirDetail.setEngine(engine);

            Optional<Hood> byId3 = hoodRepo.findById(bektemirDetailDto.getHoodDto());
            Hood hood = byId3.get();
            bektemirDetail.setHood(hood);

            Optional<Mirrors> byId4 = mirrorsRepo.findById(bektemirDetailDto.getMirrorsDto());
            Mirrors mirrors = byId4.get();
            bektemirDetail.setMirrors(mirrors);

            Optional<Roof> byId5 = roofRepo.findById(bektemirDetailDto.getRoofDto());
            Roof roof = byId5.get();
            bektemirDetail.setRoof(roof);

            Optional<Seats> byId6 = seatsRepo.findById(bektemirDetailDto.getSeatsDto());
            Seats seats = byId6.get();
            bektemirDetail.setSeats(seats);

            Optional<Tires> byId7 = tiresRepo.findById(bektemirDetailDto.getTiresDto());
            Tires tires = byId7.get();
            bektemirDetail.setTires(tires);

            Optional<Transmission> byId8 = transmissionRepo.findById(bektemirDetailDto.getTransmissionDto());
            Transmission transmission = byId8.get();
            bektemirDetail.setTransmission(transmission);

            Optional<Wheels> byId9 = wheelsRepo.findById(bektemirDetailDto.getWheelsDto());
            Wheels wheels = byId9.get();
            bektemirDetail.setWheels(wheels);

            bektemirDetailRepo.save(bektemirDetail);
            return new Result("Bektemir detail information updated successfully", true);
        }
        return new Result("Bektemir detail information not found", false);
    }

    public Result delete(UUID id) {
        Optional<BektemirDetail> byId = bektemirDetailRepo.findById(id);
        if (byId.isPresent()) {
            bektemirDetailRepo.deleteById(id);
            return new Result("Bektemir detail information deleted successfully", true);
        }
        return new Result("Bektemir detail information not found", false);
    }

}