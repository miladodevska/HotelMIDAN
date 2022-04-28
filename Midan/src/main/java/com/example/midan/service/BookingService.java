package com.example.midan.service;

import com.example.midan.model.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    List<Booking> listAllBookings();

    Booking findById(Long id);

    Booking book (LocalDate checkIn, LocalDate checkOut, Long offerId, Long guestId);
}
