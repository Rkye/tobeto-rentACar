package com.spring.rentACar.entities;

import jakarta.persistence.*;

@Entity
@Table(name="cars")
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

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
