package com.spring.rentACar.dtos.responses.county;

import com.spring.rentACar.entities.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCountyResponse {
    private String cityName;
    private String name;
}
