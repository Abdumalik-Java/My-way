package abdumalik.dev.myway.service;

import abdumalik.dev.myway.dto.LoginDto;
import abdumalik.dev.myway.model.Login;
import abdumalik.dev.myway.model.Ramification;
import abdumalik.dev.myway.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoginService {

    @Autowired
    LoginRepo repo;

    public List<Login> findAll() {
        return repo.findAll();
    }

    public Login findById(UUID id) {
        return repo.findById(id).get();
    }

    public Ramification create(LoginDto dto) {
        boolean b = repo.existsByEmailOrUsername(dto.getEmail(), dto.getUsername());
        if (b) {
            return new Ramification("Email or Username is already exist", false);
        }

        Login login = new Login();
        login.setEmail(dto.getEmail());
        login.setUsername(dto.getUsername());
        login.setPassword(dto.getPassword());
        login.setConfirmPassword(dto.getConfirmPassword());
        repo.save(login);
        return new Ramification("Successfully created", true);
    }

    public Ramification update(UUID id, LoginDto dto) {
        Optional<Login> byId = repo.findById(id);
        if (byId.isPresent()) {
            Login login = byId.get();
            login.setEmail(dto.getEmail());
            login.setUsername(dto.getUsername());
            login.setPassword(dto.getPassword());
            login.setConfirmPassword(dto.getConfirmPassword());
            repo.save(login);
            return new Ramification("Successfully updated", true);
        }
        return new Ramification("Not found", false);
    }

    public Ramification delete(UUID id) {
        Optional<Login> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Ramification("Successfully deleted", true);
        }
        return new Ramification("Not found", false);
    }

}