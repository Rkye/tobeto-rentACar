package com.spring.rentACar.services.dtos.requests.bill;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBillRequest {
    @NotBlank(message = "Tarih boş geçilemez.")
    private LocalDate date;
    @Size(min = 4, max = 8, message = "Tutar en az 4, en fazla 8 haneli olmalıdır.")
    private double price;
}
