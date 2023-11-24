package com.spring.rentACar.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarListResponse {
    private int modelYear;
    private String modelName;
    private double price;
}
