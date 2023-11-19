package com.spring.rentACar.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "payment_type")
    private String paymentType;

    @OneToMany(mappedBy = "order")
    List<Car> cars;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    //TODO one-to-one (Order - Bill)

}
