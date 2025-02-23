package com.example.webjpahackathon.service.carServicesService.detailRegionService;

import com.example.webjpahackathon.dto.carServicesDto.detailRegionDto.MirzoUlugbekDetailDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.*;
import com.example.webjpahackathon.model.carServices.detailRegion.MirzoUlugbekDetail;
import com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo.MirzoUlugbekDetailRepo;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MirzoUlugbekDetailService {

    @Autowired
    MirzoUlugbekDetailRepo mirzoUlugbekDetailRepo;

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

    public List<MirzoUlugbekDetail> readAllMirzoUlugbekDetails() {
        return mirzoUlugbekDetailRepo.findAll();
    }

    public MirzoUlugbekDetail readMirzoUlugbekDetail(UUID id) {
        return mirzoUlugbekDetailRepo.findById(id).get();
    }

    public MirzoUlugbekDetail readByName(String name) {
        return mirzoUlugbekDetailRepo.findByStoreName(name).get();
    }

    public Result create(MirzoUlugbekDetailDto mirzoUlugbekDetailDto) {
        MirzoUlugbekDetail mirzoUlugbekDetail = new MirzoUlugbekDetail();
        mirzoUlugbekDetail.setStoreName(mirzoUlugbekDetailDto.getStoreName());
        mirzoUlugbekDetail.setLatitute(mirzoUlugbekDetailDto.getLatitute());
        mirzoUlugbekDetail.setLongtitute(mirzoUlugbekDetailDto.getLongtitute());

        Optional<Bumper> byId = bumperRepo.findById(mirzoUlugbekDetailDto.getBumperDto());
        Bumper bumper = byId.get();
        mirzoUlugbekDetail.setBumper(bumper);

        Optional<Door> byId1 = doorRepo.findById(mirzoUlugbekDetailDto.getDoorDto());
        Door door = byId1.get();
        mirzoUlugbekDetail.setDoor(door);

        Optional<Engine> byId2 = engineRepo.findById(mirzoUlugbekDetailDto.getEngineDto());
        Engine engine = byId2.get();
        mirzoUlugbekDetail.setEngine(engine);

        Optional<Hood> byId3 = hoodRepo.findById(mirzoUlugbekDetailDto.getHoodDto());
        Hood hood = byId3.get();
        mirzoUlugbekDetail.setHood(hood);

        Optional<Mirrors> byId4 = mirrorsRepo.findById(mirzoUlugbekDetailDto.getMirrorsDto());
        Mirrors mirrors = byId4.get();
        mirzoUlugbekDetail.setMirrors(mirrors);

        Optional<Roof> byId5 = roofRepo.findById(mirzoUlugbekDetailDto.getRoofDto());
        Roof roof = byId5.get();
        mirzoUlugbekDetail.setRoof(roof);

        Optional<Seats> byId6 = seatsRepo.findById(mirzoUlugbekDetailDto.getSeatsDto());
        Seats seats = byId6.get();
        mirzoUlugbekDetail.setSeats(seats);

        Optional<Tires> byId7 = tiresRepo.findById(mirzoUlugbekDetailDto.getTiresDto());
        Tires tires = byId7.get();
        mirzoUlugbekDetail.setTires(tires);

        Optional<Transmission> byId8 = transmissionRepo.findById(mirzoUlugbekDetailDto.getTransmissionDto());
        Transmission transmission = byId8.get();
        mirzoUlugbekDetail.setTransmission(transmission);

        Optional<Wheels> byId9 = wheelsRepo.findById(mirzoUlugbekDetailDto.getWheelsDto());
        Wheels wheels = byId9.get();
        mirzoUlugbekDetail.setWheels(wheels);

        mirzoUlugbekDetailRepo.save(mirzoUlugbekDetail);
        return new Result("Mirzo Ulug`bek details information created successfully", true);
    }

    public Result update(MirzoUlugbekDetailDto mirzoUlugbekDetailDto, UUID id) {
        Optional<MirzoUlugbekDetail> byId = mirzoUlugbekDetailRepo.findById(id);
        if (byId.isPresent()) {
            MirzoUlugbekDetail mirzoUlugbekDetail = byId.get();
            mirzoUlugbekDetail.setStoreName(mirzoUlugbekDetailDto.getStoreName());
            mirzoUlugbekDetail.setLatitute(mirzoUlugbekDetailDto.getLatitute());
            mirzoUlugbekDetail.setLongtitute(mirzoUlugbekDetailDto.getLongtitute());

            Optional<Bumper> byIdorg = bumperRepo.findById(mirzoUlugbekDetailDto.getBumperDto());
            Bumper bumper = byIdorg.get();
            mirzoUlugbekDetail.setBumper(bumper);

            Optional<Door> byId1 = doorRepo.findById(mirzoUlugbekDetailDto.getDoorDto());
            Door door = byId1.get();
            mirzoUlugbekDetail.setDoor(door);

            Optional<Engine> byId2 = engineRepo.findById(mirzoUlugbekDetailDto.getEngineDto());
            Engine engine = byId2.get();
            mirzoUlugbekDetail.setEngine(engine);

            Optional<Hood> byId3 = hoodRepo.findById(mirzoUlugbekDetailDto.getHoodDto());
            Hood hood = byId3.get();
            mirzoUlugbekDetail.setHood(hood);

            Optional<Mirrors> byId4 = mirrorsRepo.findById(mirzoUlugbekDetailDto.getMirrorsDto());
            Mirrors mirrors = byId4.get();
            mirzoUlugbekDetail.setMirrors(mirrors);

            Optional<Roof> byId5 = roofRepo.findById(mirzoUlugbekDetailDto.getRoofDto());
            Roof roof = byId5.get();
            mirzoUlugbekDetail.setRoof(roof);

            Optional<Seats> byId6 = seatsRepo.findById(mirzoUlugbekDetailDto.getSeatsDto());
            Seats seats = byId6.get();
            mirzoUlugbekDetail.setSeats(seats);

            Optional<Tires> byId7 = tiresRepo.findById(mirzoUlugbekDetailDto.getTiresDto());
            Tires tires = byId7.get();
            mirzoUlugbekDetail.setTires(tires);

            Optional<Transmission> byId8 = transmissionRepo.findById(mirzoUlugbekDetailDto.getTransmissionDto());
            Transmission transmission = byId8.get();
            mirzoUlugbekDetail.setTransmission(transmission);

            Optional<Wheels> byId9 = wheelsRepo.findById(mirzoUlugbekDetailDto.getWheelsDto());
            Wheels wheels = byId9.get();
            mirzoUlugbekDetail.setWheels(wheels);

            mirzoUlugbekDetailRepo.save(mirzoUlugbekDetail);
            return new Result("Mirzo Ulug`bek details information updated successfully", true);
        }
        return new Result("Mirzo Ulug`bek details not found", false);
    }

    public Result delete(UUID id) {
        Optional<MirzoUlugbekDetail> byId = mirzoUlugbekDetailRepo.findById(id);
        if (byId.isPresent()) {
            mirzoUlugbekDetailRepo.deleteById(id);
            return new Result("Mirzo Ulug`bek details deleted successfully", true);
        }
        return new Result("Mirzo Ulug`bek details not found", false);
    }

}