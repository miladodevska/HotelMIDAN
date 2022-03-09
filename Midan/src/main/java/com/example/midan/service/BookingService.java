package com.example.midan.service;

import com.example.midan.model.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    List<Booking> listAllBookings();

    Booking findById(Long id);

    Booking create(LocalDate checkIn, LocalDate checkOut, LocalDate bookingDate, boolean paymentStatus, boolean bookingStatus);

    Booking update(Long id, LocalDate checkIn, LocalDate checkOut, LocalDate bookingDate, boolean paymentStatus, boolean bookingStatus);

    Booking delete(Long id);
}
