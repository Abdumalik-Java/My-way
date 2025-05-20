package abdumalik.dev.myway.service;

import abdumalik.dev.myway.dto.CarWashDto;
import abdumalik.dev.myway.model.CarWash;
import abdumalik.dev.myway.model.Payment;
import abdumalik.dev.myway.model.Ramification;
import abdumalik.dev.myway.repository.CarWashRepo;
import abdumalik.dev.myway.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarWashService {

    @Autowired
    CarWashRepo repo;

    @Autowired
    PaymentRepo paymentRepo;

    public List<CarWash> getAllCarWash() {
        return repo.findAll();
    }

    public CarWash getCarWashById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<CarWash> getByName(String name) {
        return repo.findByName(name);
    }

    public Optional<CarWash> getByLocation(String location) {
        return repo.findByLocation(location);
    }

    public Ramification create(CarWashDto dto) {
        CarWash carWash = new CarWash();
        carWash.setName(dto.getName());
        carWash.setLocation(dto.getLocation());
        carWash.setDescription(dto.getDescription());
        carWash.setOpenedAt(dto.getOpenedAt());
        carWash.setClosedAt(dto.getClosedAt());
        carWash.setStatus(dto.isStatus());

        Optional<Payment> byId = paymentRepo.findById(dto.getPaymentId());
        Payment payment = byId.get();
        carWash.setPayment(payment);

        repo.save(carWash);
        return new Ramification("CarWash info created successfully", true);
    }

    public Ramification update(UUID id, CarWashDto dto) {
        Optional<CarWash> byId = repo.findById(id);
        if (byId.isPresent()) {
            CarWash carWash = byId.get();
            carWash.setName(dto.getName());
            carWash.setLocation(dto.getLocation());
            carWash.setDescription(dto.getDescription());
            carWash.setOpenedAt(dto.getOpenedAt());
            carWash.setClosedAt(dto.getClosedAt());
            carWash.setStatus(dto.isStatus());

            Optional<Payment> byPaymentId = paymentRepo.findById(dto.getPaymentId());
            Payment payment = byPaymentId.get();
            carWash.setPayment(payment);

            repo.save(carWash);
            return new Ramification("CarWash info updated successfully", true);
        }
        return new Ramification("CarWash info not found", false);
    }

    public Ramification delete(UUID id) {
        Optional<CarWash> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Ramification("CarWash info deleted successfully", true);
        }
        return new Ramification("CarWash info not found", false);
    }

}