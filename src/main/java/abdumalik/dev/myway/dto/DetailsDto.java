package abdumalik.dev.myway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailsDto {

    private UUID car;
    private String detailName;
    private String detailDescription;
    private Double detailPrice;
    private boolean detailStatus;

}