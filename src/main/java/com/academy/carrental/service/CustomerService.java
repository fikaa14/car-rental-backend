package com.academy.carrental.service;

import com.academy.carrental.entity.Customer;
import com.academy.carrental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void saveCustomer(Customer customer)
    {
        customerRepository.save(customer);
    }

    public Integer getLastId()
    {
        return customerRepository.getLastId();
    }
}
