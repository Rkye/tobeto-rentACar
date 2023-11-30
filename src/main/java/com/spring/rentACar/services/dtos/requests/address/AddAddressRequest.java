package com.spring.rentACar.services.dtos.requests.address;

import com.spring.rentACar.entities.City;
import com.spring.rentACar.entities.County;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddAddressRequest {
    private String postalCode;
    private String addressText;
    private County county;
}