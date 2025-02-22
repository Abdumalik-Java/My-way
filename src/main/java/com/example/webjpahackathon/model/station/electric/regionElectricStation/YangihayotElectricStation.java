package com.example.webjpahackathon.model.station.electric.regionElectricStation;

import com.example.webjpahackathon.model.station.electric.charger.Fast;
import com.example.webjpahackathon.model.station.electric.charger.Slow;
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
public class YangihayotElectricStation {

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

    @OneToOne
    private Fast fast;

    @OneToOne
    private Slow slow;

}