package com.academy.carrental.controller;

import com.academy.carrental.dto.VehicleDTO;
import com.academy.carrental.entity.Vehicle;
import com.academy.carrental.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping("get-all")
    public ResponseEntity<List<VehicleDTO>> getAll(Pageable pageable)
    {
        List<VehicleDTO> resultList = vehicleService.getAllVehicles(pageable);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping("get-all-sorted-by/price-asc")
    public ResponseEntity<List<VehicleDTO>> getAllSortedByPriceAsc(Pageable pageable)
    {
        List<VehicleDTO> resultList = vehicleService.getAllSortedByPriceAsc(pageable);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping("get-all-sorted-by/price-desc")
    public ResponseEntity<List<VehicleDTO>> getAllSortedByPriceDesc(Pageable pageable)
    {
        List<VehicleDTO> resultList = vehicleService.getAllSortedByPriceDesc(pageable);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping("get-all-sorted-by/production-year-asc")
    public ResponseEntity<List<VehicleDTO>> getAllSortedByProductionYearAsc(Pageable pageable)
    {
        List<VehicleDTO> resultList = vehicleService.getAllSortedByProductionYearAsc(pageable);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping("get-all-sorted-by/production-year-desc")
    public ResponseEntity<List<VehicleDTO>> getAllSortedByProductionYearDesc(Pageable pageable)
    {
        List<VehicleDTO> resultList = vehicleService.getAllSortedByProductionYearDesc(pageable);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping("get-all-available")
    public ResponseEntity<List<VehicleDTO>> getAllAvailable(Pageable pageable)
    {
        List<VehicleDTO> resultList = vehicleService.getAllAvailable(true, pageable);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping("get-number")
    public ResponseEntity<Long> getNumber()
    {
        long vehicleNumber = vehicleService.getNumber();
        return new ResponseEntity<>(vehicleNumber, HttpStatus.OK);
    }

    @GetMapping("get-by-id/{id}")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable Integer id)
    {
        VehicleDTO vehicle = vehicleService.getById(id);
        if(vehicle!=null && vehicle.getId()!=null && vehicle.getIsAvaliable()!=null &&
            vehicle.getTransmission()!=null && vehicle.getCategory()!=null && vehicle.getImgPath()!=null &&
            vehicle.getMileage()!=null && vehicle.getModel()!=null &&
            vehicle.getPlateNumber()!=null && vehicle.getProductionYear()!=null) {
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("get-category-names")
    public ResponseEntity<List<String>> getCategoryNames()
    {
        List<String> categoryNames = vehicleService.getCategoryNames();
        return new ResponseEntity<>(categoryNames, HttpStatus.OK);
    }

    @GetMapping("get-vehicles-number-by-category/{category}")
    public ResponseEntity<Integer> getVehiclesNumberByCategory(@PathVariable String category)
    {
        Integer numberOfVehiclesByCategory = vehicleService.countVehiclesNumberByCategory(category);
        return new ResponseEntity<>(numberOfVehiclesByCategory, HttpStatus.OK);
    }

    @GetMapping("get-by-category/{category}")
    public ResponseEntity<List<VehicleDTO>> getByCategory(@PathVariable String category, Pageable pageable)
    {
        List<VehicleDTO> resultList = vehicleService.getByCategory(category, pageable);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping("get-sorted-by-type-and-category/{sort}&{category}")
    public ResponseEntity<List<VehicleDTO>> getSortedByTypeAndCategory
            (@PathVariable("sort")String sort,
             @PathVariable("category") String category,
             Pageable pageable)
    {
        List<VehicleDTO> resultList = vehicleService.getAllSortedByTypeAndCategory(sort, category, pageable);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @PutMapping("save-unavailable")
    public ResponseEntity<Void> changeToUnavailable(@RequestBody Vehicle vehicle)
    {
        vehicleService.changeToUnavailable(vehicle.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id)
    {
        vehicleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
