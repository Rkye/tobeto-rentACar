package com.spring.rentACar.services.dtos.requests.address;

import com.spring.rentACar.entities.City;
import com.spring.rentACar.entities.County;
import com.spring.rentACar.services.dtos.responses.county.GetCountyResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressRequest {
    private String addressText;
    private String postalCode;
}
