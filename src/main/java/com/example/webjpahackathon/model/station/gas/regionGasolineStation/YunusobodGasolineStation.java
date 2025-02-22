package com.example.webjpahackathon.model.station.gas.regionGasolineStation;

import com.example.webjpahackathon.model.station.gas.gasolineAi.Ai100;
import com.example.webjpahackathon.model.station.gas.gasolineAi.Ai80;
import com.example.webjpahackathon.model.station.gas.gasolineAi.Ai92;
import com.example.webjpahackathon.model.station.gas.gasolineAi.Ai95;
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
public class YunusobodGasolineStation {

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
    private Ai80 ai80;
    @OneToOne
    private Ai92 ai92;
    @OneToOne
    private Ai95 ai95;
    @OneToOne
    private Ai100 ai100;

}