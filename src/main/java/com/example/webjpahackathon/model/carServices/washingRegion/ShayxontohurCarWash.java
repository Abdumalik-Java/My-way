package com.example.webjpahackathon.model.carServices.washingRegion;

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
public class ShayxontohurCarWash {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String brandName;
    @Column(nullable = false)
    private BigDecimal longtitute;
    @Column(nullable = false)
    private BigDecimal latitute;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String washMachine;
    @Column(nullable = false)
    private String handWash;
    @Column(nullable = false)
    private String price;

}