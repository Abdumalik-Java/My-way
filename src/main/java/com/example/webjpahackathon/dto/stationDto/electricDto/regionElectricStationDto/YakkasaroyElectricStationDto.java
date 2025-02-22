package com.example.webjpahackathon.dto.stationDto.electricDto.regionElectricStationDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YakkasaroyElectricStationDto {

    private String brandName;
    private BigDecimal longtitute;
    private BigDecimal latitute;
    private String description;

    private UUID fastDto;
    private UUID slowDto;

}