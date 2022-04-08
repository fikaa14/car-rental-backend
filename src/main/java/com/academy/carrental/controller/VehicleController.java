package com.academy.carrental.controller;

import com.academy.carrental.entity.Vehicle;
import com.academy.carrental.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping("get-all")
    public ResponseEntity<List<Vehicle>> getAll()
    {
        List<Vehicle> vehicleList = vehicleService.getAllVehicles();
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    @GetMapping("get-all-sorted-by/price-asc")
    public ResponseEntity<List<Vehicle>> getAllSortedByPriceAsc()
    {
        List<Vehicle> vehicleList = vehicleService.getAllSortedByPriceAsc();
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    @GetMapping("get-all-sorted-by/price-desc")
    public ResponseEntity<List<Vehicle>> getAllSortedByPriceDesc()
    {
        List<Vehicle> vehicleList = vehicleService.getAllSortedByPriceDesc();
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    @GetMapping("get-all-sorted-by/production-year-asc")
    public ResponseEntity<List<Vehicle>> getAllSortedByProductionYearAsc()
    {
        List<Vehicle> vehicleList = vehicleService.getAllSortedByProductionYearAsc();
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    @GetMapping("get-all-sorted-by/production-year-desc")
    public ResponseEntity<List<Vehicle>> getAllSortedByProductionYearDesc()
    {
        List<Vehicle> vehicleList = vehicleService.getAllSortedByProductionYearDesc();
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    @GetMapping("get-all-available")
    public ResponseEntity<List<Vehicle>> getAllAvailable()
    {
        List<Vehicle> vehicleList = vehicleService.getAllAvailable(true);
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }
}
