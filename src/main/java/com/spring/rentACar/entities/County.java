package com.spring.rentACar.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "counties")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonIgnore
    private City city;
}
