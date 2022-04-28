package com.example.midan.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Booking {

    public Booking() {
    }

    public Booking(String checkIn, String checkOut) {
        this.checkIn = LocalDate.parse(checkIn);
        this.checkOut = LocalDate.parse(checkOut);
        this.bookingDate = LocalDate.now();
    }

    public Booking(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingDate = LocalDate.now();
    }


    public Booking(LocalDate checkIn, LocalDate checkOut, Offer offer, Guest guest) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingDate = LocalDate.now();
        this.offer = offer;
        this.guest = guest;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate checkIn;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate checkOut;

    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDate bookingDate;

    @ManyToOne()
    private Room room;

    @ManyToOne()
    private Guest guest;

    @ManyToOne()
    private Offer offer;

}
