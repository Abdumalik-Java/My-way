package com.example.webjpahackathon.model.carServices;

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
public class TowingServices {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private BigDecimal longitude;
    @Column(nullable = false)
    private BigDecimal latitude;
    @Column(nullable = false)
    private String price;

}