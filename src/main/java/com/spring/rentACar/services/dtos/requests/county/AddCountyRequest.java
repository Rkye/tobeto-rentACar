package com.spring.rentACar.services.dtos.requests.county;

import com.spring.rentACar.entities.City;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCountyRequest {
    private City city;
    @NotBlank(message = "İlçe adı boş geçilemez.")
    @Size(min = 3, message = "İlçe en az 3 karakter olabilir.")
    private String name;
}
