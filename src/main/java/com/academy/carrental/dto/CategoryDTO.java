package com.academy.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Integer id;
    private Integer maxPeopleCapacity;
    private Integer maxBaggageCapacity;
    private String name;
    private Double pricePerDay;

}
