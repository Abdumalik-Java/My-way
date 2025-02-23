package com.example.webjpahackathon.service;

import com.example.webjpahackathon.dto.UserDto;
import com.example.webjpahackathon.model.Car;
import com.example.webjpahackathon.model.Result;
import com.example.webjpahackathon.model.User;
import com.example.webjpahackathon.repository.CarRepo;
import com.example.webjpahackathon.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    CarRepo carRepo;

    public List<User> readAll() {
        return userRepo.findAll();
    }

    public User readById(UUID id) {
        return userRepo.findById(id).get();
    }

    public Result create(UserDto userDto) {

        boolean b = userRepo.existsByEmail(userDto.getEmail());
        if (b) {
            return new Result("User information already exists", false);
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        Optional<Car> optionalCar = carRepo.findById(userDto.getCarDto());
        Car car = optionalCar.get();
        user.setCar(car);

        userRepo.save(user);
        return new Result("User information created successfully", true);
    }

    public Result update(UserDto userDto, UUID id) {
        Optional<User> byId = userRepo.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());

            Optional<Car> optionalCar = carRepo.findById(userDto.getCarDto());
            Car car = optionalCar.get();
            user.setCar(car);

            userRepo.save(user);
            return new Result("User information updated successfully", true);
        }
        return new Result("User information not found", false);
    }

    public Result delete(UUID id) {
        Optional<User> byId = userRepo.findById(id);
        if (byId.isPresent()) {
            userRepo.deleteById(id);
            return new Result("User information deleted successfully", true);
        }
        return new Result("User information not found", false);
    }

}