package com.example.webjpahackathon.service.carServicesService;

import com.example.webjpahackathon.dto.carServicesDto.CarDetailsDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.CarDetails;
import com.example.webjpahackathon.model.carServices.detailRegion.*;
import com.example.webjpahackathon.repository.carServicesRepo.CarDetailsRepo;
import com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarDetailsService {

    @Autowired
    CarDetailsRepo carDetailsRepo;

    @Autowired
    BektemirDetailRepo bektemirDetailRepo;

    @Autowired
    ChilanzarDetailRepo chilanzarDetailRepo;

    @Autowired
    MirobodDetailRepo mirobodDetailRepo;

    @Autowired
    MirzoUlugbekDetailRepo mirzoUlugbekDetailRepo;

    @Autowired
    OlmazorDetailRepo olmazorDetailRepo;

    @Autowired
    SergeliDetailRepo sergeliDetailRepo;

    @Autowired
    ShayxontohurDetailRepo shayxontohurDetailRepo;

    @Autowired
    UchtepaDetailRepo uchtepaDetailRepo;

    @Autowired
    YakkasaroyDetailRepo yakkasaroyDetailRepo;

    @Autowired
    YangihayotDetailRepo yangihayotDetailRepo;

    @Autowired
    YashnabodDetailRepo yashnabodDetailRepo;

    @Autowired
    YunusobodDetailRepo yunusobodDetailRepo;

    public List<CarDetails> readAll() {
        return carDetailsRepo.findAll();
    }

    public CarDetails readById(UUID id) {
        return carDetailsRepo.findById(id).get();
    }

    public CarDetails readByRegionName(String name) {
        return carDetailsRepo.findByRegionName(name).get();
    }

    public Result create(CarDetailsDto carDetailsDto) {
        CarDetails carDetails = new CarDetails();
        carDetails.setRegionName(carDetailsDto.getRegionName());
        carDetails.setDescription(carDetailsDto.getDescription());

        Optional<BektemirDetail> byId = bektemirDetailRepo.findById(carDetailsDto.getBektemirDetailDto());
        BektemirDetail bektemirDetail = byId.get();
        carDetails.setBektemirDetail(bektemirDetail);

        Optional<ChilanzarDetail> byId1 = chilanzarDetailRepo.findById(carDetailsDto.getChilanzarDetailDto());
        ChilanzarDetail chilanzarDetail = byId1.get();
        carDetails.setChilanzarDetail(chilanzarDetail);

        Optional<MirobodDetail> byId2 = mirobodDetailRepo.findById(carDetailsDto.getMirobodDetailDto());
        MirobodDetail mirobodDetail = byId2.get();
        carDetails.setMirobodDetail(mirobodDetail);

        Optional<MirzoUlugbekDetail> byId3 = mirzoUlugbekDetailRepo.findById(carDetailsDto.getMirzoUlugbekDetailDto());
        MirzoUlugbekDetail mirzoUlugbekDetail = byId3.get();
        carDetails.setMirzoUlugbekDetail(mirzoUlugbekDetail);

        Optional<OlmazorDetail> byId4 = olmazorDetailRepo.findById(carDetailsDto.getOlmazorDetailDto());
        OlmazorDetail olmazorDetail = byId4.get();
        carDetails.setOlmazorDetail(olmazorDetail);

        Optional<SergeliDetail> byId5 = sergeliDetailRepo.findById(carDetailsDto.getSergeliDetailDto());
        SergeliDetail sergeliDetail = byId5.get();
        carDetails.setSergeliDetail(sergeliDetail);

        Optional<ShayxontohurDetail> byId6 = shayxontohurDetailRepo.findById(carDetailsDto.getShayxontahurDetailDto());
        ShayxontohurDetail shayxontohurDetail = byId6.get();
        carDetails.setShayxontohurDetail(shayxontohurDetail);

        Optional<UchtepaDetail> byId7 = uchtepaDetailRepo.findById(carDetailsDto.getUchtepaDetailDto());
        UchtepaDetail uchtepaDetail = byId7.get();
        carDetails.setUchtepaDetail(uchtepaDetail);

        Optional<YakkasaroyDetail> byId8 = yakkasaroyDetailRepo.findById(carDetailsDto.getYakkasaroyDetailDto());
        YakkasaroyDetail yakkasaroyDetail = byId8.get();
        carDetails.setYakkasaroyDetail(yakkasaroyDetail);

        Optional<YangihayotDetail> byId9 = yangihayotDetailRepo.findById(carDetailsDto.getYashnabodDetailDto());
        YangihayotDetail yangihayotDetail = byId9.get();
        carDetails.setYangihayotDetail(yangihayotDetail);

        Optional<YashnabodDetail> byId10 = yashnabodDetailRepo.findById(carDetailsDto.getYashnabodDetailDto());
        YashnabodDetail yashnabodDetail = byId10.get();
        carDetails.setYashnabodDetail(yashnabodDetail);

        Optional<YunusobodDetail> byId11 = yunusobodDetailRepo.findById(carDetailsDto.getYunusobodDetailDto());
        YunusobodDetail yunusobodDetail = byId11.get();
        carDetails.setYunusobodDetail(yunusobodDetail);

        carDetailsRepo.save(carDetails);
        return new Result("Car details information created successfully", true);
    }

    public Result update(UUID id, CarDetailsDto carDetailsDto) {
        Optional<CarDetails> byId = carDetailsRepo.findById(id);
        if (byId.isPresent()) {
            CarDetails carDetails = byId.get();
            carDetails.setRegionName(carDetailsDto.getRegionName());
            carDetails.setDescription(carDetailsDto.getDescription());

            Optional<BektemirDetail> byIdorg = bektemirDetailRepo.findById(carDetailsDto.getBektemirDetailDto());
            BektemirDetail bektemirDetail = byIdorg.get();
            carDetails.setBektemirDetail(bektemirDetail);

            Optional<ChilanzarDetail> byId1 = chilanzarDetailRepo.findById(carDetailsDto.getChilanzarDetailDto());
            ChilanzarDetail chilanzarDetail = byId1.get();
            carDetails.setChilanzarDetail(chilanzarDetail);

            Optional<MirobodDetail> byId2 = mirobodDetailRepo.findById(carDetailsDto.getMirobodDetailDto());
            MirobodDetail mirobodDetail = byId2.get();
            carDetails.setMirobodDetail(mirobodDetail);

            Optional<MirzoUlugbekDetail> byId3 = mirzoUlugbekDetailRepo.findById(carDetailsDto.getMirzoUlugbekDetailDto());
            MirzoUlugbekDetail mirzoUlugbekDetail = byId3.get();
            carDetails.setMirzoUlugbekDetail(mirzoUlugbekDetail);

            Optional<OlmazorDetail> byId4 = olmazorDetailRepo.findById(carDetailsDto.getOlmazorDetailDto());
            OlmazorDetail olmazorDetail = byId4.get();
            carDetails.setOlmazorDetail(olmazorDetail);

            Optional<SergeliDetail> byId5 = sergeliDetailRepo.findById(carDetailsDto.getSergeliDetailDto());
            SergeliDetail sergeliDetail = byId5.get();
            carDetails.setSergeliDetail(sergeliDetail);

            Optional<ShayxontohurDetail> byId6 = shayxontohurDetailRepo.findById(carDetailsDto.getShayxontahurDetailDto());
            ShayxontohurDetail shayxontohurDetail = byId6.get();
            carDetails.setShayxontohurDetail(shayxontohurDetail);

            Optional<UchtepaDetail> byId7 = uchtepaDetailRepo.findById(carDetailsDto.getUchtepaDetailDto());
            UchtepaDetail uchtepaDetail = byId7.get();
            carDetails.setUchtepaDetail(uchtepaDetail);

            Optional<YakkasaroyDetail> byId8 = yakkasaroyDetailRepo.findById(carDetailsDto.getYakkasaroyDetailDto());
            YakkasaroyDetail yakkasaroyDetail = byId8.get();
            carDetails.setYakkasaroyDetail(yakkasaroyDetail);

            Optional<YangihayotDetail> byId9 = yangihayotDetailRepo.findById(carDetailsDto.getYashnabodDetailDto());
            YangihayotDetail yangihayotDetail = byId9.get();
            carDetails.setYangihayotDetail(yangihayotDetail);

            Optional<YashnabodDetail> byId10 = yashnabodDetailRepo.findById(carDetailsDto.getYashnabodDetailDto());
            YashnabodDetail yashnabodDetail = byId10.get();
            carDetails.setYashnabodDetail(yashnabodDetail);

            Optional<YunusobodDetail> byId11 = yunusobodDetailRepo.findById(carDetailsDto.getYunusobodDetailDto());
            YunusobodDetail yunusobodDetail = byId11.get();
            carDetails.setYunusobodDetail(yunusobodDetail);

            carDetailsRepo.save(carDetails);
            return new Result("Car details information created successfully", true);
        }
        return new Result("Car details information not found", false);
    }

    public Result delete(UUID id) {
        Optional<CarDetails> byId = carDetailsRepo.findById(id);
        if (byId.isPresent()) {
            carDetailsRepo.deleteById(id);
            return new Result("Car details information deleted successfully", true);
        }
        return new Result("Car details information not found", false);
    }

}