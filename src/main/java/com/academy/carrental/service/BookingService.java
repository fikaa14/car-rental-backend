package com.academy.carrental.service;

import com.academy.carrental.entity.Booking;
import com.academy.carrental.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public void saveBooking(Booking booking)
    {
        bookingRepository.save(booking);
    }

}
