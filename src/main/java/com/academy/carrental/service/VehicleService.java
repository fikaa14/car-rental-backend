package com.academy.carrental.service;

import com.academy.carrental.dto.VehicleDTO;
import com.academy.carrental.entity.Vehicle;
import com.academy.carrental.mapper.VehicleMapper;
import com.academy.carrental.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public List<VehicleDTO> getAllVehicles(Pageable pageable)
    {
        Page<Vehicle> page = vehicleRepository.findAll(pageable);
        return getVehicleDTOS(page);
    }

    public List<VehicleDTO> getAllSortedByPriceAsc(Pageable pageable)
    {
        Page<Vehicle> page = vehicleRepository.findAllSortedPriceAsc(pageable);
        return getVehicleDTOS(page);
    }

    public List<VehicleDTO> getAllSortedByPriceDesc(Pageable pageable)
    {
        Page<Vehicle> page = vehicleRepository.findAllSortedPriceDesc(pageable);
        return getVehicleDTOS(page);
    }

    public List<VehicleDTO> getAllSortedByProductionYearAsc(Pageable pageable)
    {
        Page<Vehicle> page = vehicleRepository.findAllSortedByProductionYearAsc(pageable);
        return getVehicleDTOS(page);
    }

    public List<VehicleDTO> getAllSortedByProductionYearDesc(Pageable pageable)
    {
        Page<Vehicle> page = vehicleRepository.findAllSortedByProductionYearDesc(pageable);
        return getVehicleDTOS(page);
    }

    public List<VehicleDTO> getAllAvailable(Boolean isAvailable, Pageable pageable)
    {
        Page<Vehicle> page = vehicleRepository.findAllByIsAvaliableEquals(isAvailable, pageable);
        return getVehicleDTOS(page);
    }

    public long getNumber()
    { return vehicleRepository.count(); }

    public VehicleDTO getById(Integer id)
    {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        if(vehicleOptional.isPresent())
        {
            Vehicle vehicle = vehicleOptional.get();
            return vehicleMapper.convertToDTO(vehicle);
        }
        else
        {
            return null;
        }
    }

    public List<VehicleDTO> getByCategory(String category, Pageable pageable)
    {
        Page<Vehicle> page = vehicleRepository.findAllByCategoryName(category, pageable);
        return getVehicleDTOS(page);
    }

    public List<String> getCategoryNames()
    {
        List<String> categoryNames = vehicleRepository.getAllCategoryNames();
        return categoryNames;
    }

    public Integer countVehiclesNumberByCategory(String category)
    {
        Integer totalNumber = vehicleRepository.countAllByCategoryName(category);
        return totalNumber;
    }

    public List<VehicleDTO> getAllSortedByTypeAndCategory(String sortType, String category, Pageable pageable)
    {
        if(sortType.equals("production-year-asc"))
        {
            Page<Vehicle> page = vehicleRepository
                    .getAllByCategoryNameAndProductionYearSortedAsc(category, pageable);
            return getVehicleDTOS(page);
        }
        else if(sortType.equals("production-year-desc"))
        {
            Page<Vehicle> page = vehicleRepository
                    .getAllByCategoryNameAndProductionYearSortedDesc(category, pageable);
            return getVehicleDTOS(page);
        }
        else
        {
            return null;
        }
    }
    private List<VehicleDTO> getVehicleDTOS(Page<Vehicle> page)
    {
        if(page.hasContent())
        {
            List<Vehicle> vehicleList = page.getContent();
            List<VehicleDTO> resultList = new ArrayList<>();
            for(Vehicle vehicle: vehicleList)
            {
                resultList.add(vehicleMapper.convertToDTO(vehicle));
            }

            return resultList;
        }
        return null;
    }

    public void changeToUnavailable(Integer id)
    {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        if(vehicleOptional.isPresent())
        {
            Vehicle vehicle = vehicleOptional.get();
            vehicle.setIsAvaliable(false);
            vehicleRepository.save(vehicle);
        }
    }

    public void deleteById(Integer id)
    {
        vehicleRepository.deleteById(id);
    }
}
