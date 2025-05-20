package abdumalik.dev.myway.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private Car car;
    @Column(nullable = false)
    private String detailName;
    @Column(nullable = false)
    private String detailDescription;
    @Column(nullable = false)
    private Double detailPrice;
    @Column(nullable = false)
    private boolean detailStatus;

}