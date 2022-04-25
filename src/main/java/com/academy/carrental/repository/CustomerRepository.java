package com.academy.carrental.repository;

import com.academy.carrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(
            value="select customer.id from customer " +
                    "order by customer.id desc limit 1",
            nativeQuery = true
    )
    Integer getLastId();

}
