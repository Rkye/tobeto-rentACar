package com.spring.rentACar.services.dtos.requests.bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBillRequest {
    private LocalDate date;
    private double price;
}
