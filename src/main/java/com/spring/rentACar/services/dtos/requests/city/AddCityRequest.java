package com.spring.rentACar.services.dtos.requests.city;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCityRequest {
    @NotBlank(message = "Şehir boş geçilemez.")
    @Size(min = 3, message = "Şehir en az 3 karakter olabilir.")
    private String name;
}
