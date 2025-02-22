package com.example.webjpahackathon.model.region;

import com.example.webjpahackathon.model.carServices.CarDetails;
import com.example.webjpahackathon.model.carServices.CarWash;
import com.example.webjpahackathon.model.carServices.TowingServices;
import com.example.webjpahackathon.model.parking.ParkingPlaces;
import com.example.webjpahackathon.model.parking.PlacesForDisabledPeople;
import com.example.webjpahackathon.model.station.electric.ElectricCarStation;
import com.example.webjpahackathon.model.station.gas.GasolineStation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bektemir {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    @ManyToMany
    private List<CarDetails> carDetails;
    @ManyToMany
    private List<CarWash> carWash;
    @OneToOne
    private TowingServices towingServices;
    @ManyToMany
    private List<ParkingPlaces> parkingPlaces;
    @ManyToMany
    private List<PlacesForDisabledPeople> placesForDisabledPeople;
    @ManyToMany
    private List<ElectricCarStation> electricCarStation;
    @ManyToMany
    private List<GasolineStation> gasolineStation;

}
