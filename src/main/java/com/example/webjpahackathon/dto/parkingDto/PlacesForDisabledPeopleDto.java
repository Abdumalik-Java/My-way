package com.example.webjpahackathon.dto.parkingDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlacesForDisabledPeopleDto {

    private String name;
    private BigDecimal longtitute;
    private BigDecimal latitute;

}