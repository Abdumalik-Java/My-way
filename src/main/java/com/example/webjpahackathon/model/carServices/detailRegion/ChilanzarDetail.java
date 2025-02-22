package com.example.webjpahackathon.model.carServices.detailRegion;

import com.example.webjpahackathon.model.carServices.detail.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChilanzarDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String storeName;
    @Column(nullable = false)
    private BigDecimal longtitute;
    @Column(nullable = false)
    private BigDecimal latitute;

    @OneToOne
    private Bumper bumper;
    @OneToOne
    private Door door;
    @OneToOne
    private Engine engine;
    @OneToOne
    private Hood hood;
    @OneToOne
    private Mirrors mirrors;
    @OneToOne
    private Roof roof;
    @OneToOne
    private Seats seats;
    @OneToOne
    private Tires tires;
    @OneToOne
    private Transmission transmission;
    @OneToOne
    private Wheels wheels;

}
