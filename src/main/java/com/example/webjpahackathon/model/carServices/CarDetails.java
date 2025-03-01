package com.example.webjpahackathon.model.carServices;

import com.example.webjpahackathon.model.carServices.detailRegion.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String regionName;
    @Column(nullable = false)
    private String description;

    @ManyToOne
    private BektemirDetail bektemirDetail;
    @ManyToOne
    private ChilanzarDetail chilanzarDetail;
    @ManyToOne
    private MirobodDetail mirobodDetail;
    @ManyToOne
    private MirzoUlugbekDetail mirzoUlugbekDetail;
    @ManyToOne
    private OlmazorDetail olmazorDetail;
    @ManyToOne
    private SergeliDetail sergeliDetail;
    @ManyToOne
    private ShayxontohurDetail shayxontohurDetail;
    @ManyToOne
    private UchtepaDetail uchtepaDetail;
    @ManyToOne
    private YakkasaroyDetail yakkasaroyDetail;
    @ManyToOne
    private YangihayotDetail yangihayotDetail;
    @ManyToOne
    private YashnabodDetail yashnabodDetail;
    @ManyToOne
    private YunusobodDetail yunusobodDetail;

}