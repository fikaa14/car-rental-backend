package com.academy.carrental.service;

import com.academy.carrental.entity.Vehicle;
import com.academy.carrental.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles()
    { return vehicleRepository.findAll(); }

    public List<Vehicle> getAllSortedByPriceAsc()
    { return vehicleRepository.findAllSortedPriceAsc(); }

    public List<Vehicle> getAllSortedByPriceDesc()
    { return vehicleRepository.findAllSortedPriceDesc(); }

    public List<Vehicle> getAllSortedByProductionYearAsc()
    { return vehicleRepository.findAllSortedByProductionYearAsc();}

    public List<Vehicle> getAllSortedByProductionYearDesc()
    { return vehicleRepository.findAllSortedByProductionYearDesc();}

    public List<Vehicle> getAllAvailable(Boolean isAvailable)
    { return vehicleRepository.findAllByIsAvaliableEquals(isAvailable);}
}
