package com.academy.carrental.controller;

import com.academy.carrental.entity.Bill;
import com.academy.carrental.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping("save-bill")
    public ResponseEntity<Void> saveBill(@RequestBody Bill bill)
    {
        if(bill!=null &&  bill.getDate()!=null && bill.getTaxes()!=null && bill.getTotal()!=null)
        {
            billService.saveBill(bill);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
