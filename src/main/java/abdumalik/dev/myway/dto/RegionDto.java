package abdumalik.dev.myway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionDto {

    private String name;
    private String description;
    private UUID carServices;
    private UUID carWashes;
    private UUID parkingList;
    private UUID stationList;
    private UUID storeList;

}