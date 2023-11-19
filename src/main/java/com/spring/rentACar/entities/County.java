package com.spring.rentACar.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "counties")
public class County {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "county")
    List<Address> addresses;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
