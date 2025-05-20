package abdumalik.dev.myway.controller;

import abdumalik.dev.myway.dto.StoreDto;
import abdumalik.dev.myway.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readAll() {
        return new ResponseEntity<>(service.getAllStores(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readById(@PathVariable UUID id) {
        return new ResponseEntity<>(service.getStoreById(id), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readByName(@PathVariable String name) {
        return new ResponseEntity<>(service.getStoreByName(name), HttpStatus.OK);
    }

    @GetMapping("/{location}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readByLocation(@PathVariable String location) {
        return new ResponseEntity<>(service.getByLocation(location), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> createStore(@RequestBody StoreDto storeDto) {
        return new ResponseEntity<>(service.create(storeDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> updateStore(@PathVariable UUID id, @RequestBody StoreDto storeDto) {
        return new ResponseEntity<>(service.update(id, storeDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN')")
    public HttpEntity<?> deleteStore(@PathVariable UUID id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}