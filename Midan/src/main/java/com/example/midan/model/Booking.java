package com.example.midan.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Booking {

    public Booking() {
    }

    public Booking(LocalDate checkIn, LocalDate checkOut, LocalDate bookingDate, boolean paymentStatus, boolean bookingStatus) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingDate = bookingDate;
        this.paymentStatus = paymentStatus;
        this.bookingStatus = bookingStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private LocalDate bookingDate; //koga e napravena rezervacijata

    private boolean paymentStatus;

    private boolean bookingStatus;

    @ManyToOne()
    private Room room;

    @ManyToOne()
    private Guest guest;

}
