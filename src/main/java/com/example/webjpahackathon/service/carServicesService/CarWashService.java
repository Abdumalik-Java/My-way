package com.example.webjpahackathon.service.carServicesService;

import com.example.webjpahackathon.dto.carServicesDto.CarWashDto;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.carServices.CarWash;
import com.example.webjpahackathon.model.carServices.detailRegion.YunusobodDetail;
import com.example.webjpahackathon.model.carServices.washingRegion.*;
import com.example.webjpahackathon.repository.carServicesRepo.CarWashRepo;
import com.example.webjpahackathon.repository.carServicesRepo.detailRegionRepo.YunusobodDetailRepo;
import com.example.webjpahackathon.repository.carServicesRepo.washingRegion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarWashService {

    @Autowired
    CarWashRepo carWashRepo;

    @Autowired
    BektemirCarWashRepo bektemirCarWashRepo;

    @Autowired
    ChilanzarCarWashRepo chilanzarCarWashRepo;

    @Autowired
    MirobodCarWashRepo mirobodCarWashRepo;

    @Autowired
    MirzoUlugbekCarWashRepo mirzoUlugbekCarWashRepo;

    @Autowired
    OlmazorCarWashRepo olmazorCarWashRepo;

    @Autowired
    SergeliCarWashRepo sergeliCarWashRepo;

    @Autowired
    ShayxontohurCarWashRepo shayxontohurCarWashRepo;

    @Autowired
    UchtepaCarWashRepo uchtepaCarWashRepo;

    @Autowired
    YakkasaroyCarWashRepo yakkasaroyCarWashRepo;

    @Autowired
    YangihayotCarWashRepo yangihayotCarWashRepo;

    @Autowired
    YashnabodCarWashRepo yashnabodCarWashRepo;

    @Autowired
    YunusobodCarWashRepo yunusobodCarWashRepo;

    public List<CarWash> readAll() {
        return carWashRepo.findAll();
    }

    public CarWash readById(UUID id) {
        return carWashRepo.findById(id).get();
    }

    public CarWash readByName(String name) {
        return carWashRepo.findByBrandName(name).get();
    }

    public Result create(CarWashDto carWashDto) {
        CarWash carWash = new CarWash();
        carWash.setBrandName(carWashDto.getBrandName());
        carWash.setDescription(carWashDto.getDescription());

        Optional<BektemirCarWash> byId = bektemirCarWashRepo.findById(carWashDto.getBektemirCarWashingDto());
        BektemirCarWash bektemirCarWash = byId.get();
        carWash.setBektemirCarWashing(bektemirCarWash);

        Optional<ChilanzarCarWash> byId1 = chilanzarCarWashRepo.findById(carWashDto.getChilanzarCarWashingDto());
        ChilanzarCarWash chilanzarCarWash = byId1.get();
        carWash.setChilanzarCarWashing(chilanzarCarWash);

        Optional<MirobodCarWash> byId2 = mirobodCarWashRepo.findById(carWashDto.getMirobodCarWashingDto());
        MirobodCarWash mirobodCarWash = byId2.get();
        carWash.setMirobodCarWashing(mirobodCarWash);

        Optional<MirzoUlugbekCarWash> byId3 = mirzoUlugbekCarWashRepo.findById(carWashDto.getMirzoUlugbekCarWashingDto());
        MirzoUlugbekCarWash mirzoUlugbekCarWash = byId3.get();
        carWash.setMirzoUlugbekCarWashing(mirzoUlugbekCarWash);

        Optional<OlmazorCarWash> byId4 = olmazorCarWashRepo.findById(carWashDto.getOlmazorCarWashingDto());
        OlmazorCarWash olmazorCarWash = byId4.get();
        carWash.setOlmazorCarWashing(olmazorCarWash);

        Optional<SergeliCarWash> byId5 = sergeliCarWashRepo.findById(carWashDto.getSergeliCarWashingDto());
        SergeliCarWash sergeliCarWash = byId5.get();
        carWash.setSergeliCarWashing(sergeliCarWash);

        Optional<ShayxontohurCarWash> byId6 = shayxontohurCarWashRepo.findById(carWashDto.getShayxontohurCarWashingDto());
        ShayxontohurCarWash shayxontohurCarWash = byId6.get();
        carWash.setShayxontohurCarWashing(shayxontohurCarWash);

        Optional<UchtepaCarWash> byId7 = uchtepaCarWashRepo.findById(carWashDto.getUchtepaCarWashingDto());
        UchtepaCarWash uchtepaCarWash = byId7.get();
        carWash.setUchtepaCarWashing(uchtepaCarWash);

        Optional<YakkasaroyCarWash> byId8 = yakkasaroyCarWashRepo.findById(carWashDto.getYakkasaroyCarWashingDto());
        YakkasaroyCarWash yakkasaroyCarWash = byId8.get();
        carWash.setYakkasaroyCarWashing(yakkasaroyCarWash);

        Optional<YangihayotCarWash> byId9 = yangihayotCarWashRepo.findById(carWashDto.getYangihayotCarWashingDto());
        YangihayotCarWash yangihayotCarWash = byId9.get();
        carWash.setYangihayotCarWashing(yangihayotCarWash);

        Optional<YashnabodCarWash> byId10 = yashnabodCarWashRepo.findById(carWashDto.getYashnabodCarWashingDto());
        YashnabodCarWash yashnabodCarWash = byId10.get();
        carWash.setYashnabodCarWashing(yashnabodCarWash);

        Optional<YunusobodCarWash> byId11 = yunusobodCarWashRepo.findById(carWashDto.getYunusobodCarWashingDto());
        YunusobodCarWash yunusobodCarWash = byId11.get();
        carWash.setYunusobodCarWashing(yunusobodCarWash);

        carWashRepo.save(carWash);
        return new Result("Car wash information created successfully", true);
    }

    public Result update(UUID id, CarWashDto carWashDto) {
        Optional<CarWash> byId = carWashRepo.findById(id);
        if (byId.isPresent()) {
            CarWash carWash = byId.get();
            carWash.setBrandName(carWashDto.getBrandName());
            carWash.setDescription(carWashDto.getDescription());

            Optional<BektemirCarWash> byIdorg = bektemirCarWashRepo.findById(carWashDto.getBektemirCarWashingDto());
            BektemirCarWash bektemirCarWash = byIdorg.get();
            carWash.setBektemirCarWashing(bektemirCarWash);

            Optional<ChilanzarCarWash> byId1 = chilanzarCarWashRepo.findById(carWashDto.getChilanzarCarWashingDto());
            ChilanzarCarWash chilanzarCarWash = byId1.get();
            carWash.setChilanzarCarWashing(chilanzarCarWash);

            Optional<MirobodCarWash> byId2 = mirobodCarWashRepo.findById(carWashDto.getMirobodCarWashingDto());
            MirobodCarWash mirobodCarWash = byId2.get();
            carWash.setMirobodCarWashing(mirobodCarWash);

            Optional<MirzoUlugbekCarWash> byId3 = mirzoUlugbekCarWashRepo.findById(carWashDto.getMirzoUlugbekCarWashingDto());
            MirzoUlugbekCarWash mirzoUlugbekCarWash = byId3.get();
            carWash.setMirzoUlugbekCarWashing(mirzoUlugbekCarWash);

            Optional<OlmazorCarWash> byId4 = olmazorCarWashRepo.findById(carWashDto.getOlmazorCarWashingDto());
            OlmazorCarWash olmazorCarWash = byId4.get();
            carWash.setOlmazorCarWashing(olmazorCarWash);

            Optional<SergeliCarWash> byId5 = sergeliCarWashRepo.findById(carWashDto.getSergeliCarWashingDto());
            SergeliCarWash sergeliCarWash = byId5.get();
            carWash.setSergeliCarWashing(sergeliCarWash);

            Optional<ShayxontohurCarWash> byId6 = shayxontohurCarWashRepo.findById(carWashDto.getShayxontohurCarWashingDto());
            ShayxontohurCarWash shayxontohurCarWash = byId6.get();
            carWash.setShayxontohurCarWashing(shayxontohurCarWash);

            Optional<UchtepaCarWash> byId7 = uchtepaCarWashRepo.findById(carWashDto.getUchtepaCarWashingDto());
            UchtepaCarWash uchtepaCarWash = byId7.get();
            carWash.setUchtepaCarWashing(uchtepaCarWash);

            Optional<YakkasaroyCarWash> byId8 = yakkasaroyCarWashRepo.findById(carWashDto.getYakkasaroyCarWashingDto());
            YakkasaroyCarWash yakkasaroyCarWash = byId8.get();
            carWash.setYakkasaroyCarWashing(yakkasaroyCarWash);

            Optional<YangihayotCarWash> byId9 = yangihayotCarWashRepo.findById(carWashDto.getYangihayotCarWashingDto());
            YangihayotCarWash yangihayotCarWash = byId9.get();
            carWash.setYangihayotCarWashing(yangihayotCarWash);

            Optional<YashnabodCarWash> byId10 = yashnabodCarWashRepo.findById(carWashDto.getYashnabodCarWashingDto());
            YashnabodCarWash yashnabodCarWash = byId10.get();
            carWash.setYashnabodCarWashing(yashnabodCarWash);

            Optional<YunusobodCarWash> byId11 = yunusobodCarWashRepo.findById(carWashDto.getYunusobodCarWashingDto());
            YunusobodCarWash yunusobodCarWash = byId11.get();
            carWash.setYunusobodCarWashing(yunusobodCarWash);

            carWashRepo.save(carWash);
            return new Result("Car wash information updated successfully", true);
        }
        return new Result("Car wash information not found", false);
    }

    public Result delete(UUID id) {
        Optional<CarWash> byId = carWashRepo.findById(id);
        if (byId.isPresent()) {
            carWashRepo.deleteById(id);
            return new Result("Car wash information deleted successfully", true);
        }
        return new Result("Car wash information not found", false);
    }

}