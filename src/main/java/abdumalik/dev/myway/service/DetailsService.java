package abdumalik.dev.myway.service;

import abdumalik.dev.myway.dto.DetailsDto;
import abdumalik.dev.myway.model.Car;
import abdumalik.dev.myway.model.Details;
import abdumalik.dev.myway.model.Ramification;
import abdumalik.dev.myway.repository.CarRepo;
import abdumalik.dev.myway.repository.DetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DetailsService {

    @Autowired
    DetailsRepo repo;

    @Autowired
    CarRepo carRepo;

    public List<Details> getAllDetails() {
        return repo.findAll();
    }

    public Details getDetailsById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Details> getDetailsByName(String name) {
        return repo.findByDetailName(name);
    }

    public Optional<Details> getByCar(Car car) {
        return repo.findByCar(car);
    }

    public Ramification create(DetailsDto dto) {
        Details details = new Details();

        Optional<Car> byId = carRepo.findById(dto.getCar());
        Car car = byId.get();
        details.setCar(car);

        details.setDetailName(dto.getDetailName());
        details.setDetailDescription(dto.getDetailDescription());
        details.setDetailPrice(dto.getDetailPrice());
        details.setDetailStatus(dto.isDetailStatus());
        repo.save(details);
        return new Ramification("Details info created successfully", true);
    }

    public Ramification update(UUID id, DetailsDto dto) {
        Optional<Details> byId = repo.findById(id);
        if (byId.isPresent()) {
            Details details = byId.get();

            Optional<Car> byId1 = carRepo.findById(dto.getCar());
            Car car = byId1.get();
            details.setCar(car);

            details.setDetailName(dto.getDetailName());
            details.setDetailDescription(dto.getDetailDescription());
            details.setDetailPrice(dto.getDetailPrice());
            details.setDetailStatus(dto.isDetailStatus());
            repo.save(details);
            return new Ramification("Details info updated successfully", true);
        }
        return new Ramification("Details info not found", false);
    }

    public Ramification delete(UUID id) {
        Optional<Details> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Ramification("Details info deleted successfully", true);
        }
        return new Ramification("Details info not found", false);
    }

}