package com.example.webjpahackathon.model.carServices;

import com.example.webjpahackathon.model.carServices.washingRegion.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarWash {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    @ManyToOne
    private BektemirCarWash bektemirCarWashing;
    @ManyToOne
    private ChilanzarCarWash chilanzarCarWashing;
    @ManyToOne
    private MirobodCarWash mirobodCarWashing;
    @ManyToOne
    private MirzoUlugbekCarWash mirzoUlugbekCarWashing;
    @ManyToOne
    private OlmazorCarWash olmazorCarWashing;
    @ManyToOne
    private SergeliCarWash sergeliCarWashing;
    @ManyToOne
    private ShayxontahurCarWash shayxontahurCarWashing;
    @ManyToOne
    private UchtepaCarWash uchtepaCarWashing;
    @ManyToOne
    private YakkasaroyCarWash yakkasaroyCarWashing;
    @ManyToOne
    private YangihayotCarWash yangihayotCarWashing;
    @ManyToOne
    private YashnabodCarWash yashnabodCarWashing;
    @ManyToOne
    private YunusobodCarWash yunusobodCarWashing;


}
