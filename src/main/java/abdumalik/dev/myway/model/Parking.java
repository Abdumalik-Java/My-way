package abdumalik.dev.myway.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDate openedAt;
    @Column(nullable = false)
    private LocalDate closedAt;
    @OneToOne
    private Payment payment;
    @Column(nullable = false)
    private boolean status;
    @CreatedDate
    private LocalDateTime startTime = LocalDateTime.now();

}