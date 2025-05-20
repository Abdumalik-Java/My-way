package abdumalik.dev.myway.service;

import abdumalik.dev.myway.dto.UserDto;
import abdumalik.dev.myway.model.Car;
import abdumalik.dev.myway.model.Payment;
import abdumalik.dev.myway.model.Ramification;
import abdumalik.dev.myway.model.User;
import abdumalik.dev.myway.repository.CarRepo;
import abdumalik.dev.myway.repository.PaymentRepo;
import abdumalik.dev.myway.repository.UserRepo;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepo repo;

    @Autowired
    CarRepo carRepo;

    @Autowired
    PaymentRepo paymentRepo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<User> findByEmail(@Email String email) {
        return repo.findByEmail(email);
    }

    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    public Ramification create(UserDto dto) {
        boolean b = repo.existsByEmailOrUsername(dto.getEmail(), dto.getUsername());
        if (b) {
            return new Ramification("Email or Username is already exist", false);
        }

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        Optional<Car> byId = carRepo.findById(dto.getCarId());
        Car car = byId.get();
        user.setCar(car);

        user.setVisitCount(dto.getVisitCount() + 1);

        Optional<Payment> byId1 = paymentRepo.findById(dto.getPaymentId());
        Payment payment = byId1.get();
        user.setPayment(payment);

        user.setHasPaid(dto.isHasPaid());
        repo.save(user);
        return new Ramification("Successfully created user information", true);
    }

    public Ramification update(UUID id, UserDto dto) {
        Optional<User> byId = repo.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());

            Optional<Car> byId1 = carRepo.findById(dto.getCarId());
            Car car = byId1.get();
            user.setCar(car);

            user.setVisitCount(dto.getVisitCount() + 1);

            Optional<Payment> byId2 = paymentRepo.findById(dto.getPaymentId());
            Payment payment = byId2.get();
            user.setPayment(payment);

            user.setHasPaid(dto.isHasPaid());
            repo.save(user);
            return new Ramification("Successfully updated user information", true);
        }
        return new Ramification("User not found", false);
    }

    public Ramification delete(UUID id) {
        Optional<User> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Ramification("Successfully deleted user information", true);
        }
        return new Ramification("User not found", false);
    }

}