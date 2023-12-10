package com.spring.rentACar.services.dtos.requests.address;

import com.spring.rentACar.entities.County;
import com.spring.rentACar.services.dtos.responses.county.GetCountyResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddAddressRequest {
    @NotBlank(message = "Posta kodu boş geçilemez.")
    private String postalCode;
    @NotBlank(message = "Adres alanı boş geçilemez.")
    private String addressText;
}
