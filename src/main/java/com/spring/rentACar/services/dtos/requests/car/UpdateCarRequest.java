package com.spring.rentACar.services.dtos.requests.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
    private int modelYear;
    private String modelName;
    private String color;
    private double price;
}
