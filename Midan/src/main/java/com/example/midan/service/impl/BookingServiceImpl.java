package com.example.midan.service.impl;

import com.example.midan.model.Booking;
import com.example.midan.model.Exceptions.InvalidBookingIdException;
import com.example.midan.repository.BookingRepository;
import com.example.midan.service.BookingService;

import java.time.LocalDate;
import java.util.List;

public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> listAllBookings() {
        return this.bookingRepository.findAll();
    }

    @Override
    public Booking findById(Long id) {
        return this.bookingRepository.findById(id).orElseThrow(InvalidBookingIdException::new);
    }

    @Override
    public Booking create(LocalDate checkIn, LocalDate checkOut, LocalDate bookingDate, boolean paymentStatus, boolean bookingStatus) {
        Booking booking = new Booking(checkIn, checkOut, bookingDate, paymentStatus, bookingStatus);
        return this.bookingRepository.save(booking);
    }

    @Override
    public Booking update(Long id, LocalDate checkIn, LocalDate checkOut, LocalDate bookingDate, boolean paymentStatus, boolean bookingStatus) {
        Booking booking = this.findById(id);
        booking.setCheckIn(checkIn);
        booking.setCheckOut(checkOut);
        booking.setBookingDate(bookingDate);
        booking.setPaymentStatus(paymentStatus);
        booking.setBookingStatus(bookingStatus);
        return this.bookingRepository.save(booking);
    }

    @Override
    public Booking delete(Long id) {
        Booking booking = this.findById(id);
        this.bookingRepository.delete(booking);
        return booking;
    }
}
