package com.example.webjpahackathon.dto.carServicesDto.washingRegionDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShayxontohurCarWashingDto {

    private String brandName;
    private BigDecimal longtitute;
    private BigDecimal latitute;
    private String description;
    private String washMachine;
    private String handWash;
    private String price;

}