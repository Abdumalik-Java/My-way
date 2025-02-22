package com.example.webjpahackathon.dto.regionDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OlmazorDto {

    private String name;
    private String description;

    private UUID carDetailsDto;
    private UUID carWashDto;
    private UUID towingServicesDto;
    private UUID parkingPlacesDto;
    private UUID placesForDisabledPeopleDto;
    private UUID electricCarStationDto;
    private UUID gasolineStationDto;

}