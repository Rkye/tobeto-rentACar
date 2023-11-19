package com.spring.rentACar.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "bills")
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    //TODO one-to-one (Bill - Order)

}
