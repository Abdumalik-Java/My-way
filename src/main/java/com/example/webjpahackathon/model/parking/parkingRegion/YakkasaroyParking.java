package com.example.webjpahackathon.model.parking.parkingRegion;

import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class YakkasaroyParking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int size;
    @Column(nullable = false)
    private BigDecimal longtitute;
    @Column(nullable = false)
    private BigDecimal latitute;
    @CreationTimestamp
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp updatedDate;
    @CurrentTimestamp
    private Timestamp lastVisited;
    @Column(nullable = false)
    private String price;

    @ManyToOne
    private PlacesForDisabledPeople placesForDisabledPeople;

}