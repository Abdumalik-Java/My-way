package abdumalik.dev.myway.controller;

import abdumalik.dev.myway.dto.PaymentDto;
import abdumalik.dev.myway.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readOne(@PathVariable UUID id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> create(@RequestBody PaymentDto paymentDto) {
        return new ResponseEntity<>(service.create(paymentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody PaymentDto paymentDto) {
        return new ResponseEntity<>(service.update(id, paymentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}