package com.example.webjpahackathon.dto.carServicesDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TowingServicesDto {

    private String phoneNumber;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String price;

}