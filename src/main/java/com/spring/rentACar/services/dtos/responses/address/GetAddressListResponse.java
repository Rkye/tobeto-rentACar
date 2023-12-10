package com.spring.rentACar.services.dtos.responses.address;

import com.spring.rentACar.services.dtos.responses.city.GetCityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAddressListResponse {
    private String postalCode;
    private String addressText;
    private GetCityResponse city;
}
