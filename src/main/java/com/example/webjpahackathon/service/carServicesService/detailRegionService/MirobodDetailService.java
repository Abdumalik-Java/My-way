package com.example.webjpahackathon.service.carServicesService.detailRegionService;

import com.example.webjpahackathon.dto.carServicesDto.detailRegionDto.MirobodDetailDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.*;
import com.example.webjpahackathon.model.carServices.detailRegion.ChilanzarDetail;
import com.example.webjpahackathon.model.carServices.detailRegion.MirobodDetail;
import com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo.MirobodDetailRepo;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MirobodDetailService {

    @Autowired
    MirobodDetailRepo mirobodDetailRepo;

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

    public List<MirobodDetail> readAll() {
        return mirobodDetailRepo.findAll();
    }

    public MirobodDetail readMirobodDetail(UUID id) {
        return mirobodDetailRepo.findById(id).get();
    }

    public MirobodDetail readByName(String name) {
        return mirobodDetailRepo.findByStoreName(name).get();
    }

    public Result createMirobodDetail(MirobodDetailDto mirobodDetailDto) {
        MirobodDetail mirobodDetail = new MirobodDetail();
        mirobodDetail.setStoreName(mirobodDetailDto.getStoreName());
        mirobodDetail.setLatitute(mirobodDetailDto.getLatitute());
        mirobodDetail.setLongtitute(mirobodDetailDto.getLongtitute());

        Optional<Bumper> byId = bumperRepo.findById(mirobodDetailDto.getBumperDto());
        Bumper bumper = byId.get();
        mirobodDetail.setBumper(bumper);

        Optional<Door> byId1 = doorRepo.findById(mirobodDetailDto.getDoorDto());
        Door door = byId1.get();
        mirobodDetail.setDoor(door);

        Optional<Engine> byId2 = engineRepo.findById(mirobodDetailDto.getEngineDto());
        Engine engine = byId2.get();
        mirobodDetail.setEngine(engine);

        Optional<Hood> byId3 = hoodRepo.findById(mirobodDetailDto.getHoodDto());
        Hood hood = byId3.get();
        mirobodDetail.setHood(hood);

        Optional<Mirrors> byId4 = mirrorsRepo.findById(mirobodDetailDto.getMirrorsDto());
        Mirrors mirrors = byId4.get();
        mirobodDetail.setMirrors(mirrors);

        Optional<Roof> byId5 = roofRepo.findById(mirobodDetailDto.getRoofDto());
        Roof roof = byId5.get();
        mirobodDetail.setRoof(roof);

        Optional<Seats> byId6 = seatsRepo.findById(mirobodDetailDto.getSeatsDto());
        Seats seats = byId6.get();
        mirobodDetail.setSeats(seats);

        Optional<Tires> byId7 = tiresRepo.findById(mirobodDetailDto.getTiresDto());
        Tires tires = byId7.get();
        mirobodDetail.setTires(tires);

        Optional<Transmission> byId8 = transmissionRepo.findById(mirobodDetailDto.getTransmissionDto());
        Transmission transmission = byId8.get();
        mirobodDetail.setTransmission(transmission);

        Optional<Wheels> byId9 = wheelsRepo.findById(mirobodDetailDto.getWheelsDto());
        Wheels wheels = byId9.get();
        mirobodDetail.setWheels(wheels);

        mirobodDetailRepo.save(mirobodDetail);
        return new Result("Mirobod details information created successfully", true);
    }

    public Result updateMirobodDetail(MirobodDetailDto mirobodDetailDto, UUID id) {
        Optional<MirobodDetail> byId = mirobodDetailRepo.findById(id);
        if (byId.isPresent()) {
            MirobodDetail mirobodDetail = byId.get();
            mirobodDetail.setStoreName(mirobodDetailDto.getStoreName());
            mirobodDetail.setLatitute(mirobodDetailDto.getLatitute());
            mirobodDetail.setLongtitute(mirobodDetailDto.getLongtitute());

            Optional<Bumper> byIdorg = bumperRepo.findById(mirobodDetailDto.getBumperDto());
            Bumper bumper = byIdorg.get();
            mirobodDetail.setBumper(bumper);

            Optional<Door> byId1 = doorRepo.findById(mirobodDetailDto.getDoorDto());
            Door door = byId1.get();
            mirobodDetail.setDoor(door);

            Optional<Engine> byId2 = engineRepo.findById(mirobodDetailDto.getEngineDto());
            Engine engine = byId2.get();
            mirobodDetail.setEngine(engine);

            Optional<Hood> byId3 = hoodRepo.findById(mirobodDetailDto.getHoodDto());
            Hood hood = byId3.get();
            mirobodDetail.setHood(hood);

            Optional<Mirrors> byId4 = mirrorsRepo.findById(mirobodDetailDto.getMirrorsDto());
            Mirrors mirrors = byId4.get();
            mirobodDetail.setMirrors(mirrors);

            Optional<Roof> byId5 = roofRepo.findById(mirobodDetailDto.getRoofDto());
            Roof roof = byId5.get();
            mirobodDetail.setRoof(roof);

            Optional<Seats> byId6 = seatsRepo.findById(mirobodDetailDto.getSeatsDto());
            Seats seats = byId6.get();
            mirobodDetail.setSeats(seats);

            Optional<Tires> byId7 = tiresRepo.findById(mirobodDetailDto.getTiresDto());
            Tires tires = byId7.get();
            mirobodDetail.setTires(tires);

            Optional<Transmission> byId8 = transmissionRepo.findById(mirobodDetailDto.getTransmissionDto());
            Transmission transmission = byId8.get();
            mirobodDetail.setTransmission(transmission);

            Optional<Wheels> byId9 = wheelsRepo.findById(mirobodDetailDto.getWheelsDto());
            Wheels wheels = byId9.get();
            mirobodDetail.setWheels(wheels);

            mirobodDetailRepo.save(mirobodDetail);
            return new Result("Mirobod details information updated successfully", true);
        }
        return new Result("Mirobod details information not found", false);
    }

    public Result deleteMirobodDetail(UUID id) {
        Optional<MirobodDetail> byId = mirobodDetailRepo.findById(id);
        if (byId.isPresent()) {
            mirobodDetailRepo.deleteById(id);
            return new Result("Mirobod details information deleted successfully", true);
        }
        return new Result("Mirobod details information not found", false);
    }

}