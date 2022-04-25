package com.academy.carrental.controller;

import com.academy.carrental.entity.Customer;
import com.academy.carrental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("save")
    public ResponseEntity<Void> saveCustomer(@RequestBody Customer customer)
    {
        if(customer!=null)
        {
            customerService.saveCustomer(customer);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
