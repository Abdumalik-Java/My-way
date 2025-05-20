package abdumalik.dev.myway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarWashDto {

    private String name;
    private String location;
    private String description;
    private LocalDate openedAt;
    private LocalDate closedAt;
    private boolean status;
    private UUID paymentId;

}