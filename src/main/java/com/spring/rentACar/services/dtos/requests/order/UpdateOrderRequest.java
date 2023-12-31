package com.spring.rentACar.services.dtos.requests.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private String paymentType;
}
