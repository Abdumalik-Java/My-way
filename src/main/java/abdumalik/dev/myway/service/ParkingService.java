package abdumalik.dev.myway.service;

import abdumalik.dev.myway.dto.ParkingDto;
import abdumalik.dev.myway.model.Parking;
import abdumalik.dev.myway.model.Payment;
import abdumalik.dev.myway.model.Ramification;
import abdumalik.dev.myway.repository.ParkingRepo;
import abdumalik.dev.myway.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingService {

    @Autowired
    ParkingRepo repo;

    @Autowired
    PaymentRepo payRepo;

    public List<Parking> getAllParkings() {
        return repo.findAll();
    }

    public Parking getParkingById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Parking> getParkingByName(String name) {
        return repo.findByName(name);
    }

    public Optional<Parking> getParkingByLocation(String location) {
        return repo.findByLocation(location);
    }

    public Ramification create(ParkingDto dto) {
        Parking parking = new Parking();
        parking.setName(dto.getName());
        parking.setLocation(dto.getLocation());
        parking.setDescription(dto.getDescription());
        parking.setOpenedAt(dto.getOpenedAt());
        parking.setClosedAt(dto.getClosedAt());

        Optional<Payment> byId = payRepo.findById(dto.getPaymentId());
        Payment payment = byId.get();
        parking.setPayment(payment);

        parking.setStatus(dto.isStatus());
        repo.save(parking);
        return new Ramification("Parking info created successfully", true);
    }

    public Ramification update(UUID id, ParkingDto dto) {
        Optional<Parking> byId = repo.findById(id);
        if (byId.isPresent()) {
            Parking parking = byId.get();
            parking.setName(dto.getName());
            parking.setLocation(dto.getLocation());
            parking.setDescription(dto.getDescription());
            parking.setOpenedAt(dto.getOpenedAt());
            parking.setClosedAt(dto.getClosedAt());

            Optional<Payment> byPaymentId = payRepo.findById(dto.getPaymentId());
            Payment payment = byPaymentId.get();
            parking.setPayment(payment);

            parking.setStatus(dto.isStatus());
            repo.save(parking);
            return new Ramification("Parking info updated successfully", true);
        }
        return new Ramification("Parking not found", false);
    }

    public Ramification delete(UUID id) {
        Optional<Parking> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Ramification("Parking info deleted successfully", true);
        }
        return new Ramification("Parking not found", false);
    }

}