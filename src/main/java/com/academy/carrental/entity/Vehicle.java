package com.academy.carrental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="vehicle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="production_year")
    private String productionYear;

    @Column(name="model")
    private String model;

    @Column
    private Integer mileage;

    @Column(name = "plate_number")
    private String plateNumber;

    @Column(name = "is_avaliable")
    private Boolean isAvaliable;

    @Column(name="img_path")
    private String imgPath;

    @Column
    private Boolean transmission;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
