package com.academy.carrental.controller;

import com.academy.carrental.entity.Booking;
import com.academy.carrental.entity.Customer;
import com.academy.carrental.service.BillService;
import com.academy.carrental.service.BookingService;
import com.academy.carrental.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final CustomerService customerService;
    private final BillService billService;

    @Transactional //saveBill function simulates communication with a bank, if transaction fails booking won't be saved to database, same goes for bill, and also customer
    @PostMapping("/save-booking")
    public ResponseEntity<Void> saveBooking(@RequestBody Booking booking)
    {
        billService.saveBill(booking.getBill());
        Integer billID = billService.getLastId();
        booking.getBill().setId(billID);

        customerService.saveCustomer(booking.getCustomer());
        Integer customerID = customerService.getLastId();
        booking.getCustomer().setId(customerID);

        bookingService.saveBooking(booking);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
