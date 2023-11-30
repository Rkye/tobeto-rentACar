package com.spring.rentACar.services.dtos.requests.car;

import com.spring.rentACar.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCarRequest {
    private int modelYear;
    private String modelName;
    private String color;
    private double price;
    private Brand brand;
}
