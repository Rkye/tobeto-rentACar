package com.spring.rentACar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private  int age;

    @Column(name = "tc_no")
    private String tcNo;

    @Column(name = "gender")
    private char gender;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "customer")
    List<Address> addresses;

    @OneToMany(mappedBy = "customer")
    List<Bill> bills;

    @OneToMany(mappedBy = "customer")
    List<Order> orders;



}
