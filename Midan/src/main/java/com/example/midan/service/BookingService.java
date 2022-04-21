package com.example.midan.service;

import com.example.midan.model.Booking;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingService {

    List<Booking> listAllBookings();

    Booking findById(Long id);

    Booking book (LocalDate checkIn, LocalDate checkOut, Long roomId, Long guestId);
}
