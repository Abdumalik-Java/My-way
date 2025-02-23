package com.example.webjpahackathon.service.carServicesService.detailRegionService;

import com.example.webjpahackathon.dto.carServicesDto.detailRegionDto.UchtepaDetailDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.*;
import com.example.webjpahackathon.model.carServices.detailRegion.UchtepaDetail;
import com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo.UchtepaDetailRepo;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UchtepaDetailService {

    @Autowired
    UchtepaDetailRepo uchtepaDetailRepo;

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

    public List<UchtepaDetail> readAllUchtepaDetails() {
        return uchtepaDetailRepo.findAll();
    }

    public UchtepaDetail readUchtepaDetailById(UUID id) {
        return uchtepaDetailRepo.findById(id).get();
    }

    public UchtepaDetail readByName(String name) {
        return uchtepaDetailRepo.findByStoreName(name).get();
    }

    public Result createUchtepaDetail(UchtepaDetailDto uchtepaDetailDto) {
        UchtepaDetail uchtepaDetail = new UchtepaDetail();
        uchtepaDetail.setStoreName(uchtepaDetailDto.getStoreName());
        uchtepaDetail.setLatitute(uchtepaDetailDto.getLatitute());
        uchtepaDetail.setLongtitute(uchtepaDetailDto.getLongtitute());

        Optional<Bumper> byId = bumperRepo.findById(uchtepaDetailDto.getBumperDto());
        Bumper bumper = byId.get();
        uchtepaDetail.setBumper(bumper);

        Optional<Door> byId1 = doorRepo.findById(uchtepaDetailDto.getDoorDto());
        Door door = byId1.get();
        uchtepaDetail.setDoor(door);

        Optional<Engine> byId2 = engineRepo.findById(uchtepaDetailDto.getEngineDto());
        Engine engine = byId2.get();
        uchtepaDetail.setEngine(engine);

        Optional<Hood> byId3 = hoodRepo.findById(uchtepaDetailDto.getHoodDto());
        Hood hood = byId3.get();
        uchtepaDetail.setHood(hood);

        Optional<Mirrors> byId4 = mirrorsRepo.findById(uchtepaDetailDto.getMirrorsDto());
        Mirrors mirrors = byId4.get();
        uchtepaDetail.setMirrors(mirrors);

        Optional<Roof> byId5 = roofRepo.findById(uchtepaDetailDto.getRoofDto());
        Roof roof = byId5.get();
        uchtepaDetail.setRoof(roof);

        Optional<Seats> byId6 = seatsRepo.findById(uchtepaDetailDto.getSeatsDto());
        Seats seats = byId6.get();
        uchtepaDetail.setSeats(seats);

        Optional<Tires> byId7 = tiresRepo.findById(uchtepaDetailDto.getTiresDto());
        Tires tires = byId7.get();
        uchtepaDetail.setTires(tires);

        Optional<Transmission> byId8 = transmissionRepo.findById(uchtepaDetailDto.getTransmissionDto());
        Transmission transmission = byId8.get();
        uchtepaDetail.setTransmission(transmission);

        Optional<Wheels> byId9 = wheelsRepo.findById(uchtepaDetailDto.getWheelsDto());
        Wheels wheels = byId9.get();
        uchtepaDetail.setWheels(wheels);

        uchtepaDetailRepo.save(uchtepaDetail);
        return new Result("Uchtepa detail information found", true);
    }

    public Result updateUchtepaDetail(UchtepaDetailDto uchtepaDetailDto, UUID id) {
        Optional<UchtepaDetail> byId = uchtepaDetailRepo.findById(id);
        if (byId.isPresent()) {
            UchtepaDetail uchtepaDetail = byId.get();
            uchtepaDetail.setStoreName(uchtepaDetailDto.getStoreName());
            uchtepaDetail.setLatitute(uchtepaDetailDto.getLatitute());
            uchtepaDetail.setLongtitute(uchtepaDetailDto.getLongtitute());

            Optional<Bumper> byIdorg = bumperRepo.findById(uchtepaDetailDto.getBumperDto());
            Bumper bumper = byIdorg.get();
            uchtepaDetail.setBumper(bumper);

            Optional<Door> byId1 = doorRepo.findById(uchtepaDetailDto.getDoorDto());
            Door door = byId1.get();
            uchtepaDetail.setDoor(door);

            Optional<Engine> byId2 = engineRepo.findById(uchtepaDetailDto.getEngineDto());
            Engine engine = byId2.get();
            uchtepaDetail.setEngine(engine);

            Optional<Hood> byId3 = hoodRepo.findById(uchtepaDetailDto.getHoodDto());
            Hood hood = byId3.get();
            uchtepaDetail.setHood(hood);

            Optional<Mirrors> byId4 = mirrorsRepo.findById(uchtepaDetailDto.getMirrorsDto());
            Mirrors mirrors = byId4.get();
            uchtepaDetail.setMirrors(mirrors);

            Optional<Roof> byId5 = roofRepo.findById(uchtepaDetailDto.getRoofDto());
            Roof roof = byId5.get();
            uchtepaDetail.setRoof(roof);

            Optional<Seats> byId6 = seatsRepo.findById(uchtepaDetailDto.getSeatsDto());
            Seats seats = byId6.get();
            uchtepaDetail.setSeats(seats);

            Optional<Tires> byId7 = tiresRepo.findById(uchtepaDetailDto.getTiresDto());
            Tires tires = byId7.get();
            uchtepaDetail.setTires(tires);

            Optional<Transmission> byId8 = transmissionRepo.findById(uchtepaDetailDto.getTransmissionDto());
            Transmission transmission = byId8.get();
            uchtepaDetail.setTransmission(transmission);

            Optional<Wheels> byId9 = wheelsRepo.findById(uchtepaDetailDto.getWheelsDto());
            Wheels wheels = byId9.get();
            uchtepaDetail.setWheels(wheels);

            uchtepaDetailRepo.save(uchtepaDetail);
            return new Result("Uchtepa detail information updated", true);
        }
        return new Result("Uchtepa detail information not found", false);
    }

    public Result deleteUchtepaDetail(UUID id) {
        Optional<UchtepaDetail> byId = uchtepaDetailRepo.findById(id);
        if (byId.isPresent()) {
            uchtepaDetailRepo.deleteById(id);
            return new Result("Uchtepa detail information deleted", true);
        }
        return new Result("Uchtepa detail not found", false);
    }

}