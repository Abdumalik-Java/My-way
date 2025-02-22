package com.example.webjpahackathon.dto.stationDto.gasDto.regionGasolineStationDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OlmazorGasolineStationDto {

    private String brandName;
    private BigDecimal longtitute;
    private BigDecimal latitute;
    private String description;

    private UUID ai80Dto;
    private UUID ai92Dto;
    private UUID ai95Dto;
    private UUID ai100Dto;

}