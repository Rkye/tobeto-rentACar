package com.spring.rentACar.services.dtos.requests.order;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddOrderRequest {
    private LocalDate date;

    //@NotBlank(message = "Tarih boş geçilemez")
    @FutureOrPresent(message = "Güncel bir tarih seçiniz.")
    private LocalDate startDate;
    //@NotBlank(message = "Tarih boş geçilemez")
    @FutureOrPresent(message = "Güncel bir tarih seçiniz.")
    private LocalDate endDate;
    private double totalPrice;
    private String paymentType;
}
