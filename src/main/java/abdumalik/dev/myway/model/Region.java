package abdumalik.dev.myway.model;

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
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;

    @ManyToMany
    private List<CarServices> carServices;
    @ManyToMany
    private List<CarWash> carWashes;
    @ManyToMany
    private List<Parking> parkingList;
    @ManyToMany
    private List<Station> stationList;
    @ManyToMany
    private List<Store> storeList;

}