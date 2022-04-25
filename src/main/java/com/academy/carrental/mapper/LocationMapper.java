package com.academy.carrental.mapper;

import com.academy.carrental.dto.LocationDTO;
import com.academy.carrental.entity.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    LocationDTO convertToDTO(Location location);
}
