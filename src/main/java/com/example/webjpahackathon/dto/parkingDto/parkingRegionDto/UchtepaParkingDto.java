package com.example.webjpahackathon.dto.parkingDto.parkingRegionDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UchtepaParkingDto {

    private String name;
    private int size;
    private BigDecimal longtitute;
    private BigDecimal latitute;
    @CreationTimestamp
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp updatedDate;
    @CurrentTimestamp
    private Timestamp lastVisited;
    private String price;

}