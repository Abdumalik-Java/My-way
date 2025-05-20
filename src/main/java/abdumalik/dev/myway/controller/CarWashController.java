package abdumalik.dev.myway.controller;

import abdumalik.dev.myway.dto.CarWashDto;
import abdumalik.dev.myway.service.CarWashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/carWash")
public class CarWashController {

    @Autowired
    CarWashService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readAll() {
        return new ResponseEntity<>(service.getAllCarWash(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readById(@PathVariable UUID id) {
        return new ResponseEntity<>(service.getCarWashById(id), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readByName(@PathVariable String name) {
        return new ResponseEntity<>(service.getByName(name), HttpStatus.OK);
    }

    @GetMapping("/{location}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readByLocation(@PathVariable String location) {
        return new ResponseEntity<>(service.getByLocation(location), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody CarWashDto carWashDto) {
        return new ResponseEntity<>(service.create(carWashDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody CarWashDto carWashDto) {
        return new ResponseEntity<>(service.update(id, carWashDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}