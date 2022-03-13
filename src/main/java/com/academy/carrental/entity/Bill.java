package com.academy.carrental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="bill")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Date date;

    @Column
    private Boolean isPaid;

    @Column(name="late_fee")
    private Double lateFee;

    @Column
    private Double taxes;

    @Column
    private Double total;

    @OneToMany(mappedBy = "bill")
    @JsonIgnore
    private Set<Discount> discounts;

    @OneToMany(mappedBy = "bill")
    @JsonIgnore
    private List<Booking> bookings;
}
