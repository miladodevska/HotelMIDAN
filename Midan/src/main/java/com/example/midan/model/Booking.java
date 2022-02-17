package com.example.midan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

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

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public LocalDate getBookingDate() {return bookingDate;}

    public void setBookingDate(LocalDate bookingDate) {this.bookingDate = bookingDate;}

    public LocalDate getCheckIn() {return checkIn;}

    public void setCheckIn(LocalDate checkIn) {this.checkIn = checkIn;}

    public LocalDate getCheckOut() {return checkOut;}

    public void setCheckOut(LocalDate checkOut) {this.checkOut = checkOut;}

    public boolean getPaymentStatus() {return paymentStatus;}

    public void setPaymentStatus(boolean paymentStatus) {this.paymentStatus = paymentStatus;}

    public boolean getBookingStatus() {return bookingStatus;}

    public void setBookingStatus(boolean bookingStatus) {this.bookingStatus = bookingStatus;}
}
