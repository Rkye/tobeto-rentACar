package com.spring.rentACar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "address_text")
    private String addressText;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnore
    private City city;

    @ManyToOne
    @JoinColumn(name = "county_id")
    @JsonIgnore
    private County county;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "address")
    List<Bill> bills;

}
