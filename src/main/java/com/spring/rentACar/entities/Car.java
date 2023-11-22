package com.spring.rentACar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    // Generated Value, program tarafından otomatik oluşturulduğunu, kullanıcıdan bir değer istemediğini
    //belirtir. Stratgey kısmında da bunun identity mi yoksa generation old. mu seçilir.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Order> orders;
}
