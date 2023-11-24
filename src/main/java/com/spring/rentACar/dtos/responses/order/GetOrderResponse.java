package com.spring.rentACar.dtos.responses.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderResponse {
    private LocalDate date;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;
    private String paymentType;
}
