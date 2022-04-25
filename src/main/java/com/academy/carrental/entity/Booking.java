package com.academy.carrental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="start_rent")
    private Date startDate;

    @Column(name="end_rent")
    private Date endDate;

    @Column(name="is_active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name="bill_id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="vehicle_id")
    private Vehicle vehicle;
}
