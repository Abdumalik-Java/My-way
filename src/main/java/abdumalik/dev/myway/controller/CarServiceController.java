package abdumalik.dev.myway.controller;

import abdumalik.dev.myway.dto.CarServiceDto;
import abdumalik.dev.myway.service.CarServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/carService")
public class CarServiceController {

    @Autowired
    CarServiceService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readById(@PathVariable UUID id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
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
    public HttpEntity<?> create(@RequestBody CarServiceDto carServiceDto) {
        return new ResponseEntity<>(service.create(carServiceDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody CarServiceDto carServiceDto) {
        return new ResponseEntity<>(service.update(id, carServiceDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}