package abdumalik.dev.myway.repository;

import abdumalik.dev.myway.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StoreRepo extends JpaRepository<Store, UUID> {
    Optional<Store> findByStoreName(String storeName);
    Optional<Store> findByLocation(String location);
}