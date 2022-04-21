package com.example.midan.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Booking {

    public Booking() {
    }

    public Booking(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingDate = LocalDate.now();
    }

    public Booking(LocalDate checkIn, LocalDate checkOut, Room room, Guest guest) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingDate = LocalDate.now();
        this.room = room;
        this.guest = guest;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private LocalDate bookingDate;

    @ManyToOne()
    private Room room;

    @ManyToOne()
    private Guest guest;

}
