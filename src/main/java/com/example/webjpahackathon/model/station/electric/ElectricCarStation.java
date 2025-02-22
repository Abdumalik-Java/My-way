package com.example.webjpahackathon.model.station.electric;

import com.example.webjpahackathon.model.station.electric.regionElectricStation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ElectricCarStation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String brandName;
    @Column(nullable = false)
    private String description;

    @ManyToOne
    private BektemirElectricStation bektemirElectricStation;
    @ManyToOne
    private ChilanzarElectricStation chilanzarElectricStation;
    @ManyToOne
    private MirobodElectricStation mirobodElectricStation;
    @ManyToOne
    private MirzoUlugbekElectricStation mirzoUlugbekElectricStation;
    @ManyToOne
    private OlmazorElectricStation olmazorElectricStation;
    @ManyToOne
    private SergeliElectricStation sergeliElectricStation;
    @ManyToOne
    private ShayxontohurElectricStation shayxontohurElectricStation;
    @ManyToOne
    private UchtepaElectricStation uchtepaElectricStation;
    @ManyToOne
    private YakkasaroyElectricStation yakkasaroyElectricStation;
    @ManyToOne
    private YangihayotElectricStation yangihayotElectricStation;
    @ManyToOne
    private YashnabodElectricStation yashnabodElectricStation;
    @ManyToOne
    private YunusobodElectricStation yunusobodElectricStation;

}