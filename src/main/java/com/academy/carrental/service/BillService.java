package com.academy.carrental.service;

import com.academy.carrental.entity.Bill;
import com.academy.carrental.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public void saveBill(Bill bill)
    {
        billRepository.save(bill);
    }

    public Integer getLastId()
    {
        return billRepository.findLastAddedBill();
    }
}
