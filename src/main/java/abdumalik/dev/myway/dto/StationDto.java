package abdumalik.dev.myway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationDto {

    private String stationType;
    private String stationName;
    private String location;
    private Double price;
    private LocalDate openedAt;
    private LocalDate closedAt;
    private boolean status;
    private UUID paymentId;

}