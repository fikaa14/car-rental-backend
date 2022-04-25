package com.academy.carrental.service;

import com.academy.carrental.dto.LocationDTO;
import com.academy.carrental.entity.Location;
import com.academy.carrental.mapper.LocationMapper;
import com.academy.carrental.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public List<LocationDTO> getAll()
    {
        List<Location> locations = locationRepository.findAll();
        List<LocationDTO> resultList = new ArrayList<>();
        for(Location location: locations)
        {
            LocationDTO locationDTO = locationMapper.convertToDTO(location);
            resultList.add(locationDTO);
        }

        return resultList;
    }
}
