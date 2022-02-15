package com.example.midan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    Long BookingNum;
    int days;
    LocalDate date;

    public Booking() {
    }



}
