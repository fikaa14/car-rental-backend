package com.academy.carrental.controller;

import com.academy.carrental.dto.LocationDTO;
import com.academy.carrental.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("get-all")
    public ResponseEntity<List<LocationDTO>> getAll()
    {
        List<LocationDTO> locations = locationService.getAll();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }
}
