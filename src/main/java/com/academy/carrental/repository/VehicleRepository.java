package com.academy.carrental.repository;

import com.academy.carrental.entity.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    Page<Vehicle> findAll(Pageable pageable);

    @Query(
            value = "SELECT vehicle FROM Vehicle AS vehicle " +
                    "ORDER BY vehicle.category.pricePerDay asc"
    )
    Page<Vehicle> findAllSortedPriceAsc(Pageable pageable);

    @Query(
            value = "SELECT vehicle FROM Vehicle AS vehicle " +
                    "ORDER BY vehicle.category.pricePerDay desc"
    )
    Page<Vehicle> findAllSortedPriceDesc(Pageable pageable);

    @Query(
            value = "SELECT vehicle FROM Vehicle AS vehicle " +
                    "ORDER BY vehicle.productionYear desc "
    )
    Page<Vehicle> findAllSortedByProductionYearDesc(Pageable pageable);

    @Query(
            value = "SELECT vehicle FROM Vehicle AS vehicle " +
                    "ORDER BY vehicle.productionYear asc"
    )
    Page<Vehicle> findAllSortedByProductionYearAsc(Pageable pageable);

    Page<Vehicle> findAllByIsAvaliableEquals(Boolean isAvailable, Pageable pageable);

    Page<Vehicle> findAllByCategoryName(String category, Pageable pageable);

    @Query(
            value= "SELECT category.name FROM Category as category"
    )
    List<String> getAllCategoryNames();

    Integer countAllByCategoryName(String categoryName);

    @Query(
            value = "select vehicle.* from vehicle, category, location " +
                    "where vehicle.category_id = category.id and vehicle.location_id = location.id " +
                    "and category.name = :category order by vehicle.production_year asc",
            nativeQuery = true
    )
    Page<Vehicle> getAllByCategoryNameAndProductionYearSortedAsc(String category, Pageable pageable);

    @Query(
            value = "select vehicle.* from vehicle, category, location " +
                    "where vehicle.category_id = category.id and vehicle.location_id = location.id " +
                    "and category.name = :category order by vehicle.production_year desc",
            nativeQuery = true
    )
    Page<Vehicle> getAllByCategoryNameAndProductionYearSortedDesc(String category, Pageable pageable);

}
