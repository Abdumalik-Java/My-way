package com.example.webjpahackathon.service.carServicesService.detailRegionService;

import com.example.webjpahackathon.dto.carServicesDto.detailRegionDto.OlmazorDetailDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.detail.*;
import com.example.webjpahackathon.model.carServices.detailRegion.OlmazorDetail;
import com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo.OlmazorDetailRepo;
import com.example.webjpahackathon.repository.carServicesRepo.detailRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OlmazorDetailService {

    @Autowired
    OlmazorDetailRepo olmazorDetailRepo;

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

    public List<OlmazorDetail> readAllOlmazor() {
        return olmazorDetailRepo.findAll();
    }

    public OlmazorDetail readOlmazor(UUID id) {
        return olmazorDetailRepo.findById(id).get();
    }

    public OlmazorDetail readByName(String name) {
        return olmazorDetailRepo.findByStoreName(name).get();
    }

    public Result create(OlmazorDetailDto olmazorDetailDto) {
        OlmazorDetail olmazorDetail = new OlmazorDetail();
        olmazorDetail.setStoreName(olmazorDetailDto.getStoreName());
        olmazorDetail.setLatitute(olmazorDetailDto.getLatitute());
        olmazorDetail.setLongtitute(olmazorDetailDto.getLongtitute());

        Optional<Bumper> byId = bumperRepo.findById(olmazorDetailDto.getBumperDto());
        Bumper bumper = byId.get();
        olmazorDetail.setBumper(bumper);

        Optional<Door> byId1 = doorRepo.findById(olmazorDetailDto.getDoorDto());
        Door door = byId1.get();
        olmazorDetail.setDoor(door);

        Optional<Engine> byId2 = engineRepo.findById(olmazorDetailDto.getEngineDto());
        Engine engine = byId2.get();
        olmazorDetail.setEngine(engine);

        Optional<Hood> byId3 = hoodRepo.findById(olmazorDetailDto.getHoodDto());
        Hood hood = byId3.get();
        olmazorDetail.setHood(hood);

        Optional<Mirrors> byId4 = mirrorsRepo.findById(olmazorDetailDto.getMirrorsDto());
        Mirrors mirrors = byId4.get();
        olmazorDetail.setMirrors(mirrors);

        Optional<Seats> byId5 = seatsRepo.findById(olmazorDetailDto.getSeatsDto());
        Seats seats = byId5.get();
        olmazorDetail.setSeats(seats);

        Optional<Roof> byId6 = roofRepo.findById(olmazorDetailDto.getRoofDto());
        Roof roof = byId6.get();
        olmazorDetail.setRoof(roof);

        Optional<Tires> byId7 = tiresRepo.findById(olmazorDetailDto.getTiresDto());
        Tires tires = byId7.get();
        olmazorDetail.setTires(tires);

        Optional<Transmission> byId8 = transmissionRepo.findById(olmazorDetailDto.getTransmissionDto());
        Transmission transmission = byId8.get();
        olmazorDetail.setTransmission(transmission);

        Optional<Wheels> byId9 = wheelsRepo.findById(olmazorDetailDto.getWheelsDto());
        Wheels wheels = byId9.get();
        olmazorDetail.setWheels(wheels);

        olmazorDetailRepo.save(olmazorDetail);
        return new Result("Olmazor information created successfully", true);
    }

    public Result update(OlmazorDetailDto olmazorDetailDto, UUID id) {
        Optional<OlmazorDetail> byId = olmazorDetailRepo.findById(id);
        if (byId.isPresent()) {
            OlmazorDetail olmazorDetail = byId.get();
            olmazorDetail.setStoreName(olmazorDetailDto.getStoreName());
            olmazorDetail.setLatitute(olmazorDetailDto.getLatitute());
            olmazorDetail.setLongtitute(olmazorDetailDto.getLongtitute());

            Optional<Bumper> byIdorg = bumperRepo.findById(olmazorDetailDto.getBumperDto());
            Bumper bumper = byIdorg.get();
            olmazorDetail.setBumper(bumper);

            Optional<Door> byId1 = doorRepo.findById(olmazorDetailDto.getDoorDto());
            Door door = byId1.get();
            olmazorDetail.setDoor(door);

            Optional<Engine> byId2 = engineRepo.findById(olmazorDetailDto.getEngineDto());
            Engine engine = byId2.get();
            olmazorDetail.setEngine(engine);

            Optional<Hood> byId3 = hoodRepo.findById(olmazorDetailDto.getHoodDto());
            Hood hood = byId3.get();
            olmazorDetail.setHood(hood);

            Optional<Mirrors> byId4 = mirrorsRepo.findById(olmazorDetailDto.getMirrorsDto());
            Mirrors mirrors = byId4.get();
            olmazorDetail.setMirrors(mirrors);

            Optional<Seats> byId5 = seatsRepo.findById(olmazorDetailDto.getSeatsDto());
            Seats seats = byId5.get();
            olmazorDetail.setSeats(seats);

            Optional<Roof> byId6 = roofRepo.findById(olmazorDetailDto.getRoofDto());
            Roof roof = byId6.get();
            olmazorDetail.setRoof(roof);

            Optional<Tires> byId7 = tiresRepo.findById(olmazorDetailDto.getTiresDto());
            Tires tires = byId7.get();
            olmazorDetail.setTires(tires);

            Optional<Transmission> byId8 = transmissionRepo.findById(olmazorDetailDto.getTransmissionDto());
            Transmission transmission = byId8.get();
            olmazorDetail.setTransmission(transmission);

            Optional<Wheels> byId9 = wheelsRepo.findById(olmazorDetailDto.getWheelsDto());
            Wheels wheels = byId9.get();
            olmazorDetail.setWheels(wheels);

            olmazorDetailRepo.save(olmazorDetail);
            return new Result("Olmazor information updated successfully", true);
        }
        return new Result("Olmazor information not found", false);
    }

    public Result delete(UUID id) {
        Optional<OlmazorDetail> byId = olmazorDetailRepo.findById(id);
        if (byId.isPresent()) {
            olmazorDetailRepo.deleteById(id);
            return new Result("Olmazor information deleted successfully", true);
        }
        return new Result("Olmazor information not found", false);
    }

}