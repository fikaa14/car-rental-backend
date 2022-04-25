package com.academy.carrental.repository;

import com.academy.carrental.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {

    @Query(
            value="select bill.id from bill " +
                    "order by bill.id desc limit 1",
            nativeQuery = true
    )
    Integer findLastAddedBill();

}

