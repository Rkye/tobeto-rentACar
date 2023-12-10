package com.spring.rentACar.services.dtos.requests.car;

import com.spring.rentACar.entities.Brand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCarRequest {


    //@NotBlank(message = "Model yılı boş geçilemez.")
    private int modelYear;
    @Size(min = 2, max = 20, message = "Model adı en az 2, en uzun 20 karakter olabilir.")
    private String modelName;
    @NotBlank(message = "Renk boş geçilemez.")
    @Size(min = 3, message = "Renk en az 3 karakter olabilir.")
    private String color;

    //@NotBlank(message = "Ücret boş geçilemez.")
    private double price;
    private Brand brand;
}
