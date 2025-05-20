package abdumalik.dev.myway.service;

import abdumalik.dev.myway.dto.CarDto;
import abdumalik.dev.myway.model.Car;
import abdumalik.dev.myway.model.Ramification;
import abdumalik.dev.myway.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarService {

    @Autowired
    CarRepo repo;

    public List<Car> findAll() {
        return repo.findAll();
    }

    public Car findById(UUID id) {
        return repo.findById(id).get();
    }

    public Ramification create(CarDto dto) {
        Car car = new Car();
        car.setCarName(dto.getCarName());
        car.setCarNumber(dto.getCarNumber());
        car.setCarType(dto.getCarType());
        repo.save(car);
        return new Ramification("Car info created successfully", true);
    }

    public Ramification update(UUID id, CarDto dto) {
        Optional<Car> byId = repo.findById(id);
        if (byId.isPresent()) {
            Car car = byId.get();
            car.setCarName(dto.getCarName());
            car.setCarNumber(dto.getCarNumber());
            car.setCarType(dto.getCarType());
            repo.save(car);
            return new Ramification("Car info updated successfully", true);
        }
        return new Ramification("Car info not found", false);
    }

    public Ramification delete(UUID id) {
        Optional<Car> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.deleteById(id);
            return new Ramification("Car info deleted successfully", true);
        }
        return new Ramification("Car info not found", false);
    }

}