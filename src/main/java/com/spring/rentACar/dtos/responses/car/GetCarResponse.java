package com.spring.rentACar.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarResponse {
    private int modelYear;
    private String modelName;
    private String color;
    private double price;
    private String brandName;
}
