package abdumalik.dev.myway.service;

import abdumalik.dev.myway.dto.StationDto;
import abdumalik.dev.myway.model.Payment;
import abdumalik.dev.myway.model.Ramification;
import abdumalik.dev.myway.model.Station;
import abdumalik.dev.myway.repository.PaymentRepo;
import abdumalik.dev.myway.repository.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StationService {

    @Autowired
    StationRepo repo;

    @Autowired
    PaymentRepo paymentRepo;

    public List<Station> getAll() {
        return repo.findAll();
    }

    public Station findById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Station> findByName(String name) {
        return repo.findByStationName(name);
    }

    public Optional<Station> findByStationType(String stationType) {
        return repo.findByStationType(stationType);
    }

    public Optional<Station> findByLocation(String location) {
        return repo.findByLocation(location);
    }

    public Ramification create(StationDto dto) {
        Station station = new Station();
        station.setStationType(dto.getStationType());
        station.setStationName(dto.getStationName());
        station.setLocation(dto.getLocation());
        station.setPrice(dto.getPrice());
        station.setOpenedAt(dto.getOpenedAt());
        station.setClosedAt(dto.getClosedAt());
        station.setStatus(dto.isStatus());

        Optional<Payment> byId = paymentRepo.findById(dto.getPaymentId());
        Payment payment = byId.get();
        station.setPayment(payment);

        repo.save(station);
        return new Ramification("Station info created successfully", true);
    }

    public Ramification update(UUID id, StationDto dto) {
        Optional<Station> byId = repo.findById(id);
        if (byId.isPresent()) {
            Station station = byId.get();
            station.setStationType(dto.getStationType());
            station.setStationName(dto.getStationName());
            station.setLocation(dto.getLocation());
            station.setPrice(dto.getPrice());
            station.setOpenedAt(dto.getOpenedAt());
            station.setClosedAt(dto.getClosedAt());
            station.setStatus(dto.isStatus());

            Optional<Payment> byPaymentId = paymentRepo.findById(dto.getPaymentId());
            Payment payment = byPaymentId.get();
            station.setPayment(payment);

            repo.save(station);
            return new Ramification("Station info updated successfully", true);
        }
        return new Ramification("Station info not found", false);
    }

    public Ramification delete(UUID id) {
        Optional<Station> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Ramification("Station info deleted successfully", true);
        }
        return new Ramification("Station info not found", false);
    }

}