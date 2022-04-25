package com.academy.carrental.mapper;

import com.academy.carrental.dto.VehicleDTO;
import com.academy.carrental.entity.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    VehicleDTO convertToDTO(Vehicle vehicle);

}
