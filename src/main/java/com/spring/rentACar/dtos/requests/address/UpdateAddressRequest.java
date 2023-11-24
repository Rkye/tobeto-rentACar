package com.spring.rentACar.dtos.requests.address;

import com.spring.rentACar.entities.City;
import com.spring.rentACar.entities.County;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressRequest {
    private String addressText;
    private String postalCode;
    private City city;
    private County county;
}
