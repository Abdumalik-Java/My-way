package abdumalik.dev.myway.service;

import abdumalik.dev.myway.dto.RegionDto;
import abdumalik.dev.myway.model.*;
import abdumalik.dev.myway.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegionService {

    @Autowired
    RegionRepo repo;

    @Autowired
    CarServiceRepo carServiceRepo;

    @Autowired
    CarWashRepo carWashRepo;

    @Autowired
    ParkingRepo parkingRepo;

    @Autowired
    StationRepo stationRepo;

    @Autowired
    StoreRepo storeRepo;

    public List<Region> getAllRegions() {
        return repo.findAll();
    }

    public Region getRegionById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Region> getRegionByName(String name) {
        return repo.findByName(name);
    }

    public Ramification create(RegionDto dto) {
        Region region = new Region();
        region.setName(dto.getName());
        region.setDescription(dto.getDescription());

        Optional<CarServices> byId = carServiceRepo.findById(dto.getCarServices());
        CarServices carServices = byId.get();
        region.setCarServices((List<CarServices>) carServices);

        Optional<CarWash> byId1 = carWashRepo.findById(dto.getCarWashes());
        CarWash carWash = byId1.get();
        region.setCarWashes((List<CarWash>) carWash);

        Optional<Parking> byId2 = parkingRepo.findById(dto.getParkingList());
        Parking parking = byId2.get();
        region.setParkingList((List<Parking>) parking);

        Optional<Station> byId3 = stationRepo.findById(dto.getStationList());
        Station station = byId3.get();
        region.setStationList((List<Station>) station);

        Optional<Store> byId4 = storeRepo.findById(dto.getStoreList());
        Store store = byId4.get();
        region.setStoreList((List<Store>) store);

        repo.save(region);
        return new Ramification("Region info created successfully", true);
    }

    public Ramification update(UUID id, RegionDto dto) {
        Optional<Region> region = repo.findById(id);
        if (region.isPresent()) {
            Region region1 = region.get();
            region1.setName(dto.getName());
            region1.setDescription(dto.getDescription());

            Optional<CarServices> byId = carServiceRepo.findById(dto.getCarServices());
            CarServices carServices = byId.get();
            region1.setCarServices((List<CarServices>) carServices);

            Optional<CarWash> byId1 = carWashRepo.findById(dto.getCarWashes());
            CarWash carWash = byId1.get();
            region1.setCarWashes((List<CarWash>) carWash);

            Optional<Parking> byId2 = parkingRepo.findById(dto.getParkingList());
            Parking parking = byId2.get();
            region1.setParkingList((List<Parking>) parking);

            Optional<Station> byId3 = stationRepo.findById(dto.getStationList());
            Station station = byId3.get();
            region1.setStationList((List<Station>) station);

            Optional<Store> byId4 = storeRepo.findById(dto.getStoreList());
            Store store = byId4.get();
            region1.setStoreList((List<Store>) store);

            repo.save(region1);
            return new Ramification("Region info updated successfully", true);
        }
        return new Ramification("Region info not found", false);
    }

    public Ramification delete(UUID id) {
        Optional<Region> region = repo.findById(id);
        if (region.isPresent()) {
            repo.delete(region.get());
            return new Ramification("Region info deleted successfully", true);
        }
        return new Ramification("Region info not found", false);
    }

}