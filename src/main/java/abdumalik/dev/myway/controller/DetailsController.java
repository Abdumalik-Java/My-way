package abdumalik.dev.myway.controller;

import abdumalik.dev.myway.dto.DetailsDto;
import abdumalik.dev.myway.model.Car;
import abdumalik.dev.myway.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    DetailsService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readAll() {
        return new ResponseEntity<>(service.getAllDetails(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readById(@PathVariable UUID id) {
        return new ResponseEntity<>(service.getDetailsById(id), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readByName(@PathVariable String name) {
        return new ResponseEntity<>(service.getDetailsByName(name), HttpStatus.OK);
    }

    @GetMapping("/{car}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readByCar(@PathVariable Car car) {
        return new ResponseEntity<>(service.getByCar(car), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody DetailsDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody DetailsDto dto) {
        return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}