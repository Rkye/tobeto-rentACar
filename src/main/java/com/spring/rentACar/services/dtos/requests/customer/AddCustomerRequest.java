package com.spring.rentACar.services.dtos.requests.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCustomerRequest {
    @NotEmpty(message = "İsim boş geçilemez.")
    @Size(min = 2, message = "İsim en az 2 karakter olabilir.")
    private String name;
    @NotEmpty(message = "Soyisim boş geçilemez.")
    @Size(min = 2, message = "Soyisim en az 2 karakter olabilir.")
    private String surname;
    private  int age;
    @NotEmpty(message = "TC numarası boş geçilemez.")
    private String tcNo;
    private char gender;
    private String email;

}
