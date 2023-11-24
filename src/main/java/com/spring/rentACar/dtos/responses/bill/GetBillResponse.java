package com.spring.rentACar.dtos.responses.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBillResponse {
    private LocalDate date;
    private double price;

}
