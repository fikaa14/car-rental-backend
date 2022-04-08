package com.academy.carrental.repository;

import com.academy.carrental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findAll();

    @Query(
            value = "SELECT vehicle FROM Vehicle AS vehicle " +
                    "ORDER BY vehicle.category.pricePerDay asc"
    )
    List<Vehicle> findAllSortedPriceAsc();

    @Query(
            value = "SELECT vehicle FROM Vehicle AS vehicle " +
                    "ORDER BY vehicle.category.pricePerDay desc"
    )
    List<Vehicle> findAllSortedPriceDesc();

    @Query(
            value = "SELECT vehicle FROM Vehicle AS vehicle " +
                    "ORDER BY vehicle.productionYear desc "
    )
    List<Vehicle> findAllSortedByProductionYearDesc();

    @Query(
            value = "SELECT vehicle FROM Vehicle AS vehicle " +
                    "ORDER BY vehicle.productionYear asc"
    )
    List<Vehicle> findAllSortedByProductionYearAsc();

    List<Vehicle> findAllByIsAvaliableEquals(Boolean isAvilable);
}
