package com.example.webjpahackathon.model.station.gas;

import com.example.webjpahackathon.model.station.gas.regionGasolineStation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GasolineStation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String brandName;
    @Column(nullable = false)
    private String description;

    @ManyToOne
    private BektemirGasolineStation bektemirGasolineStation;
    @ManyToOne
    private ChilanzarGasolineStation chilanzarGasolineStation;
    @ManyToOne
    private MirobodGasolineStation mirobodGasolineStation;
    @ManyToOne
    private MirzoUlugbekGasolineStation mirzoUlugbekGasolineStation;
    @ManyToOne
    private OlmazorGasolineStation olmazorGasolineStation;
    @ManyToOne
    private SergeliGasolineStation sergeliGasolineStation;
    @ManyToOne
    private ShayxontohurGasolineStation shayxontohurGasolineStation;
    @ManyToOne
    private UchtepaGasolineStation uchtepaGasolineStation;
    @ManyToOne
    private YakkasaroyGasolineStation yakkasaroyGasolineStation;
    @ManyToOne
    private YangihayotGasolineStation yangihayotGasolineStation;
    @ManyToOne
    private YashnabodGasolineStation yashnabodGasolineStation;
    @ManyToOne
    private YunusobodGasolineStation yunusobodGasolineStation;

}