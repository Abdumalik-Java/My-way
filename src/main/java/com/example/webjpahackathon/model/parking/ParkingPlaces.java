package com.example.webjpahackathon.model.parking;

import com.example.webjpahackathon.model.parking.parkingRegion.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ParkingPlaces {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    @ManyToOne
    private BektemirParking bektemirParking;
    @ManyToOne
    private ChilanzarParking chilanzarParking;
    @ManyToOne
    private MirobodParking mirobodParking;
    @ManyToOne
    private MirzoUlugbekParking mirzoUlugbekParking;
    @ManyToOne
    private OlmazorParking olmazorParking;
    @ManyToOne
    private SergeliParking sergeliParking;
    @ManyToOne
    private ShayxontohurParking shayxontohurParking;
    @ManyToOne
    private UchtepaParking uchtepaParking;
    @ManyToOne
    private YakkasaroyParking yakkasaroyParking;
    @ManyToOne
    private YangihayotParking yangihayotParking;
    @ManyToOne
    private YashnabodParking yashnabodParking;
    @ManyToOne
    private YunusobodParking yunusobodParking;

}