package com.academy.carrental.dto;

import com.academy.carrental.entity.Booking;
import com.academy.carrental.entity.Category;
import com.academy.carrental.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private Integer id;
    private String productionYear;
    private String model;
    private Integer mileage;
    private String plateNumber;
    private Boolean isAvaliable;
    private String imgPath;
    private Boolean transmission;
    private Category category;
    private Location location;
    private List<Booking> bookings;
}
