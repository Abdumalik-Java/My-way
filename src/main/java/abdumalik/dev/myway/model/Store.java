package abdumalik.dev.myway.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String storeName;
    @ManyToOne
    private Details details;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private LocalDate openedAt;
    @Column(nullable = false)
    private LocalDate closedAt;
    @Column(nullable = false)
    private boolean status;
    @OneToOne
    private Payment payment;

}