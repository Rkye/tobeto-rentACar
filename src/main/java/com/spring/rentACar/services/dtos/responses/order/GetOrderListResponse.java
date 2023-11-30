package com.spring.rentACar.services.dtos.responses.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOrderListResponse {
    private LocalDate date;
    private double totalPrice;

}
