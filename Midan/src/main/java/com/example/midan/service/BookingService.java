package com.example.midan.service;

import com.example.midan.model.Booking;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingService {

    List<Booking> listAllBookings();

    Booking findById(Long id);

    Optional<Booking> save(LocalDate checkIn, LocalDate checkOut, LocalDate bookingDate, boolean paymentStatus, boolean bookingStatus);

    Booking create(LocalDate checkIn, LocalDate checkOut, LocalDate bookingDate, boolean paymentStatus, boolean bookingStatus);

    Booking update(Long id, LocalDate checkIn, LocalDate checkOut, LocalDate bookingDate, boolean paymentStatus, boolean bookingStatus);

    Booking delete(Long id);
}
