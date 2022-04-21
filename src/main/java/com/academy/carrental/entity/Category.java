package com.academy.carrental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="max_people")
    private Integer maxPeopleCapacity;

    @Column(name="max_baggage")
    private Integer maxBaggageCapacity;

    @Column
    private String name;

    @Column(name="day_price")
    private Double pricePerDay;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Vehicle> vehicles;
}
