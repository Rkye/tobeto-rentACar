package com.spring.rentACar.services.dtos.responses.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAddressResponse {
    private String postalCode;
    private String addressText;
    private String countyName;
    private String cityName;
}
