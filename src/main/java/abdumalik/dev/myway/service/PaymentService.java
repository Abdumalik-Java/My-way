package abdumalik.dev.myway.service;

import abdumalik.dev.myway.dto.PaymentDto;
import abdumalik.dev.myway.model.Payment;
import abdumalik.dev.myway.model.Ramification;
import abdumalik.dev.myway.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    PaymentRepo repo;

    public List<Payment> findAll() {
        return repo.findAll();
    }

    public Payment findById(UUID id) {
        return repo.findById(id).get();
    }

    public Ramification create(PaymentDto dto) {
        Payment payment = new Payment();
        payment.setName(dto.getName());
        payment.setPrice(dto.getPrice());
        payment.setMonthsPayment(dto.getMonthsPayment());
        payment.setPricePerMonth(dto.getPricePerMonth());
        repo.save(payment);
        return new Ramification("Payment info created successfully", true);
    }

    public Ramification update(UUID id, PaymentDto dto) {
        Optional<Payment> byId = repo.findById(id);
        if (byId.isPresent()) {
            Payment payment = byId.get();
            payment.setName(dto.getName());
            payment.setPrice(dto.getPrice());
            payment.setMonthsPayment(dto.getMonthsPayment());
            payment.setPricePerMonth(dto.getPricePerMonth());
            repo.save(payment);
            return new Ramification("Payment info updated successfully", true);
        }
        return new Ramification("Payment info not found", false);
    }

    public Ramification delete(UUID id) {
        Optional<Payment> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Ramification("Payment info deleted successfully", true);
        }
        return new Ramification("Payment info not found", false);
    }

}