package com.example.webjpahackathon.dto.parkingDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingPlacesDto {

    private String name;
    private String description;

    private UUID bektemirParkingDto;
    private UUID chilanzarParkingDto;
    private UUID mirobodParkingDto;
    private UUID mirzoUlugbekParkingDto;
    private UUID olmazorParkingDto;
    private UUID sergeliParkingDto;
    private UUID shayxontohurParkingDto;
    private UUID uchtepaParkingDto;
    private UUID yakkasaroyParkingDto;
    private UUID yangihayotParkingDto;
    private UUID yashnabodParkingDto;
    private UUID yunusobodParkingDto;

}