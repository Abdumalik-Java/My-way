package abdumalik.dev.myway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingDto {

    private String name;
    private String location;
    private String description;
    private LocalDate openedAt;
    private LocalDate closedAt;
    private UUID paymentId;
    private boolean status;

}