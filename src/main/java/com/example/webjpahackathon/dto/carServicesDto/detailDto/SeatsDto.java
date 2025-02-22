package com.example.webjpahackathon.dto.carServicesDto.detailDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatsDto {

    private String name;
    private String description;
    private String price;
    private String image;
    private String availability;

}