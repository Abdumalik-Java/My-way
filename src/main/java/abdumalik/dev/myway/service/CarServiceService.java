package abdumalik.dev.myway.service;

import abdumalik.dev.myway.dto.CarServiceDto;
import abdumalik.dev.myway.model.CarServices;
import abdumalik.dev.myway.model.Payment;
import abdumalik.dev.myway.model.Ramification;
import abdumalik.dev.myway.repository.CarServiceRepo;
import abdumalik.dev.myway.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarServiceService {

    @Autowired
    CarServiceRepo repo;

    @Autowired
    PaymentRepo paymentRepo;

    public List<CarServices> getAll() {
        return repo.findAll();
    }

    public CarServices getById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<CarServices> getByName(String name) {
        return repo.findByServiceName(name);
    }

    public Optional<CarServices> getByLocation(String location) {
        return repo.findByLocation(location);
    }

    public Ramification create(CarServiceDto dto) {
        CarServices carService = new CarServices();
        carService.setServiceName(dto.getServiceName());
        carService.setLocation(dto.getLocation());
        carService.setPrice(dto.getPrice());
        carService.setDescription(dto.getDescription());
        carService.setOpenedAt(dto.getOpenedAt());
        carService.setClosedAt(dto.getClosedAt());
        carService.setStatus(dto.isStatus());

        Optional<Payment> byId = paymentRepo.findById(dto.getPaymentId());
        Payment payment = byId.get();
        carService.setPayment(payment);

        repo.save(carService);
        return new Ramification("CarService info created successfully", true);
    }

    public Ramification update(UUID id, CarServiceDto dto) {
        Optional<CarServices> byId = repo.findById(id);
        if (byId.isPresent()) {
            CarServices carService = byId.get();
            carService.setServiceName(dto.getServiceName());
            carService.setLocation(dto.getLocation());
            carService.setPrice(dto.getPrice());
            carService.setDescription(dto.getDescription());
            carService.setOpenedAt(dto.getOpenedAt());
            carService.setClosedAt(dto.getClosedAt());
            carService.setStatus(dto.isStatus());

            Optional<Payment> byId1 = paymentRepo.findById(dto.getPaymentId());
            Payment payment = byId1.get();
            carService.setPayment(payment);

            repo.save(carService);
            return new Ramification("CarService info updated successfully", true);
        }
        return new Ramification("CarService info not found", false);
    }

    public Ramification delete(UUID id) {
        Optional<CarServices> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.deleteById(id);
            return new Ramification("CarService info deleted successfully", true);
        }
        return new Ramification("CarService info not found", false);
    }

}