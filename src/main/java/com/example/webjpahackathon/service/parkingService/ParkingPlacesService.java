package com.example.webjpahackathon.service.parkingService;

import com.example.webjpahackathon.dto.parkingDto.ParkingPlacesDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.parking.ParkingPlaces;
import com.example.webjpahackathon.model.parking.parkingRegion.*;
import com.example.webjpahackathon.repository.parkingRepo.ParkingPlacesRepo;
import com.example.webjpahackathon.repository.parkingRepo.parkingRegionRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingPlacesService {

    @Autowired
    ParkingPlacesRepo parkingPlacesRepo;

    @Autowired
    BektemirParkingRepo bektemirParkingRepo;

    @Autowired
    ChilanzarParkingRepo chilanzarParkingRepo;

    @Autowired
    MirobodParkingRepo mirobodParkingRepo;

    @Autowired
    MirzoUlugbekParkingRepo mirzoUlugbekParkingRepo;

    @Autowired
    OlmazorParkingRepo olmazorParkingRepo;

    @Autowired
    SergeliParkingRepo sergeliParkingRepo;

    @Autowired
    ShayxontohurParkingRepo shayxontohurParkingRepo;

    @Autowired
    UchtepaParkingRepo uchtepaParkingRepo;

    @Autowired
    YakkasaroyParkingRepo yakkasaroyParkingRepo;

    @Autowired
    YangihayotParkingRepo yangihayotParkingRepo;

    @Autowired
    YashnabodParkingRepo yashnabodParkingRepo;

    @Autowired
    YunusobodParkingRepo yunusobodParkingRepo;

    public List<ParkingPlaces> getAllParkingPlaces() {
        return parkingPlacesRepo.findAll();
    }

    public ParkingPlaces getParkingPlaceById(UUID id) {
        return parkingPlacesRepo.findById(id).get();
    }

    public ParkingPlaces getParkingPlaceByName(String name) {
        return parkingPlacesRepo.findByName(name).get();
    }

    public Result create(ParkingPlacesDto dto) {
        ParkingPlaces parkingPlaces = new ParkingPlaces();
        parkingPlaces.setName(dto.getName());
        parkingPlaces.setDescription(dto.getDescription());

        Optional<BektemirParking> byId = bektemirParkingRepo.findById(dto.getBektemirParkingDto());
        BektemirParking bektemirParking = byId.get();
        parkingPlaces.setBektemirParking(bektemirParking);

        Optional<ChilanzarParking> byId1 = chilanzarParkingRepo.findById(dto.getChilanzarParkingDto());
        ChilanzarParking chilanzarParking = byId1.get();
        parkingPlaces.setChilanzarParking(chilanzarParking);

        Optional<MirobodParking> byId2 = mirobodParkingRepo.findById(dto.getMirobodParkingDto());
        MirobodParking mirobodParking = byId2.get();
        parkingPlaces.setMirobodParking(mirobodParking);

        Optional<MirzoUlugbekParking> byId3 = mirzoUlugbekParkingRepo.findById(dto.getMirzoUlugbekParkingDto());
        MirzoUlugbekParking mirzoUlugbekParking = byId3.get();
        parkingPlaces.setMirzoUlugbekParking(mirzoUlugbekParking);

        Optional<OlmazorParking> byId4 = olmazorParkingRepo.findById(dto.getOlmazorParkingDto());
        OlmazorParking olmazorParking = byId4.get();
        parkingPlaces.setOlmazorParking(olmazorParking);

        Optional<SergeliParking> byId5 = sergeliParkingRepo.findById(dto.getSergeliParkingDto());
        SergeliParking sergeliParking = byId5.get();
        parkingPlaces.setSergeliParking(sergeliParking);

        Optional<ShayxontohurParking> byId6 = shayxontohurParkingRepo.findById(dto.getShayxontohurParkingDto());
        ShayxontohurParking shayxontohurParking = byId6.get();
        parkingPlaces.setShayxontohurParking(shayxontohurParking);

        Optional<UchtepaParking> byId7 = uchtepaParkingRepo.findById(dto.getUchtepaParkingDto());
        UchtepaParking uchtepaParking = byId7.get();
        parkingPlaces.setUchtepaParking(uchtepaParking);

        Optional<YakkasaroyParking> byId8 = yakkasaroyParkingRepo.findById(dto.getYakkasaroyParkingDto());
        YakkasaroyParking yakkasaroyParking = byId8.get();
        parkingPlaces.setYakkasaroyParking(yakkasaroyParking);

        Optional<YangihayotParking> byId9 = yangihayotParkingRepo.findById(dto.getYangihayotParkingDto());
        YangihayotParking yangihayotParking = byId9.get();
        parkingPlaces.setYangihayotParking(yangihayotParking);

        Optional<YashnabodParking> byId10 = yashnabodParkingRepo.findById(dto.getYashnabodParkingDto());
        YashnabodParking yashnabodParking = byId10.get();
        parkingPlaces.setYashnabodParking(yashnabodParking);

        Optional<YunusobodParking> byId11 = yunusobodParkingRepo.findById(dto.getYunusobodParkingDto());
        YunusobodParking yunusobodParking = byId11.get();
        parkingPlaces.setYunusobodParking(yunusobodParking);

        parkingPlacesRepo.save(parkingPlaces);
        return new Result("Parking places information created successfully", true);
    }

    public Result update(ParkingPlacesDto dto, UUID id) {
        Optional<ParkingPlaces> byId = parkingPlacesRepo.findById(id);
        if (byId.isPresent()) {
            ParkingPlaces parkingPlaces = byId.get();
            parkingPlaces.setName(dto.getName());
            parkingPlaces.setDescription(dto.getDescription());

            Optional<BektemirParking> byIdorg = bektemirParkingRepo.findById(dto.getBektemirParkingDto());
            BektemirParking bektemirParking = byIdorg.get();
            parkingPlaces.setBektemirParking(bektemirParking);

            Optional<ChilanzarParking> byId1 = chilanzarParkingRepo.findById(dto.getChilanzarParkingDto());
            ChilanzarParking chilanzarParking = byId1.get();
            parkingPlaces.setChilanzarParking(chilanzarParking);

            Optional<MirobodParking> byId2 = mirobodParkingRepo.findById(dto.getMirobodParkingDto());
            MirobodParking mirobodParking = byId2.get();
            parkingPlaces.setMirobodParking(mirobodParking);

            Optional<MirzoUlugbekParking> byId3 = mirzoUlugbekParkingRepo.findById(dto.getMirzoUlugbekParkingDto());
            MirzoUlugbekParking mirzoUlugbekParking = byId3.get();
            parkingPlaces.setMirzoUlugbekParking(mirzoUlugbekParking);

            Optional<OlmazorParking> byId4 = olmazorParkingRepo.findById(dto.getOlmazorParkingDto());
            OlmazorParking olmazorParking = byId4.get();
            parkingPlaces.setOlmazorParking(olmazorParking);

            Optional<SergeliParking> byId5 = sergeliParkingRepo.findById(dto.getSergeliParkingDto());
            SergeliParking sergeliParking = byId5.get();
            parkingPlaces.setSergeliParking(sergeliParking);

            Optional<ShayxontohurParking> byId6 = shayxontohurParkingRepo.findById(dto.getShayxontohurParkingDto());
            ShayxontohurParking shayxontohurParking = byId6.get();
            parkingPlaces.setShayxontohurParking(shayxontohurParking);

            Optional<UchtepaParking> byId7 = uchtepaParkingRepo.findById(dto.getUchtepaParkingDto());
            UchtepaParking uchtepaParking = byId7.get();
            parkingPlaces.setUchtepaParking(uchtepaParking);

            Optional<YakkasaroyParking> byId8 = yakkasaroyParkingRepo.findById(dto.getYakkasaroyParkingDto());
            YakkasaroyParking yakkasaroyParking = byId8.get();
            parkingPlaces.setYakkasaroyParking(yakkasaroyParking);

            Optional<YangihayotParking> byId9 = yangihayotParkingRepo.findById(dto.getYangihayotParkingDto());
            YangihayotParking yangihayotParking = byId9.get();
            parkingPlaces.setYangihayotParking(yangihayotParking);

            Optional<YashnabodParking> byId10 = yashnabodParkingRepo.findById(dto.getYashnabodParkingDto());
            YashnabodParking yashnabodParking = byId10.get();
            parkingPlaces.setYashnabodParking(yashnabodParking);

            Optional<YunusobodParking> byId11 = yunusobodParkingRepo.findById(dto.getYunusobodParkingDto());
            YunusobodParking yunusobodParking = byId11.get();
            parkingPlaces.setYunusobodParking(yunusobodParking);

            parkingPlacesRepo.save(parkingPlaces);
            return new Result("Parking places information updated successfully", true);
        }
        return new Result("Parking places information not found", false);
    }

    public Result delete(UUID id) {
        Optional<ParkingPlaces> byId = parkingPlacesRepo.findById(id);
        if (byId.isPresent()) {
            parkingPlacesRepo.delete(byId.get());
            return new Result("Parking places information deleted successfully", true);
        }
        return new Result("Parking places information not found", false);
    }

}