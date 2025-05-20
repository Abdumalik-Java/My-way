package abdumalik.dev.myway.service;

import abdumalik.dev.myway.dto.StoreDto;
import abdumalik.dev.myway.model.Details;
import abdumalik.dev.myway.model.Payment;
import abdumalik.dev.myway.model.Ramification;
import abdumalik.dev.myway.model.Store;
import abdumalik.dev.myway.repository.DetailsRepo;
import abdumalik.dev.myway.repository.PaymentRepo;
import abdumalik.dev.myway.repository.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StoreService {

    @Autowired
    StoreRepo repo;

    @Autowired
    DetailsRepo detailsRepo;

    @Autowired
    PaymentRepo paymentRepo;

    public List<Store> getAllStores() {
        return repo.findAll();
    }

    public Store getStoreById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Store> getStoreByName(String name) {
        return repo.findByStoreName(name);
    }

    public Optional<Store> getByLocation(String location) {
        return repo.findByLocation(location);
    }

    public Ramification create(StoreDto dto) {
        Store store = new Store();
        store.setStoreName(dto.getStoreName());

        Optional<Details> byId = detailsRepo.findById(dto.getDetailsId());
        Details details = byId.get();
        store.setDetails(details);

        store.setLocation(dto.getLocation());
        store.setOpenedAt(dto.getOpenedAt());
        store.setClosedAt(dto.getClosedAt());
        store.setStatus(dto.isStatus());

        Optional<Payment> byId1 = paymentRepo.findById(dto.getPaymentId());
        Payment payment = byId1.get();
        store.setPayment(payment);

        repo.save(store);
        return new Ramification("Store info created successfully", true);
    }

    public Ramification update(UUID id, StoreDto dto) {
        Optional<Store> byId = repo.findById(id);
        if (byId.isPresent()) {
            Store store = byId.get();
            store.setStoreName(dto.getStoreName());

            Optional<Details> byId1 = detailsRepo.findById(dto.getDetailsId());
            Details details = byId1.get();
            store.setDetails(details);

            store.setLocation(dto.getLocation());
            store.setOpenedAt(dto.getOpenedAt());
            store.setClosedAt(dto.getClosedAt());
            store.setStatus(dto.isStatus());

            Optional<Payment> byId2 = paymentRepo.findById(dto.getPaymentId());
            Payment payment = byId2.get();
            store.setPayment(payment);

            repo.save(store);
            return new Ramification("Store info updated successfully", true);
        }
        return new Ramification("Store info not found", false);
    }

    public Ramification delete(UUID id) {
        Optional<Store> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Ramification("Store info deleted successfully", true);
        }
        return new Ramification("Store info not found", false);
    }

}