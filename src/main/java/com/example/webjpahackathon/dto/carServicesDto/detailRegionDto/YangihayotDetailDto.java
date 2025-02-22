package com.example.webjpahackathon.dto.carServicesDto.detailRegionDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YangihayotDetailDto {

    private String storeName;
    private BigDecimal longtitute;
    private BigDecimal latitute;

    private UUID bumperDto;
    private UUID doorDto;
    private UUID engineDto;
    private UUID hoodDto;
    private UUID mirrorsDto;
    private UUID roofDto;
    private UUID seatsDto;
    private UUID tiresDto;
    private UUID transmissionDto;
    private UUID wheelsDto;

}