package com.example.webjpahackathon.dto.parkingDto.parkingRegionDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OlmazorParkingDto {

    private String name;
    private int size;
    private BigDecimal longtitute;
    private BigDecimal latitute;
    private String price;

    private UUID placesForDisabledPeopleDto;

}