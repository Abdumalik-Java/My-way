package com.example.webjpahackathon.dto.stationDto.electricDto.chargerDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SlowDto {

    private String name;
    private int kw;
    private int gallons;
    private String price;

}