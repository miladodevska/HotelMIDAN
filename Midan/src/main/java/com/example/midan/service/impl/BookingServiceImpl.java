package com.example.midan.service.impl;

import com.example.midan.model.Booking;
import com.example.midan.model.Exceptions.InvalidBookingIdException;
import com.example.midan.model.Exceptions.InvalidRoomIdException;
import com.example.midan.model.Exceptions.UserNotFoundException;
import com.example.midan.model.Guest;
import com.example.midan.model.Room;
import com.example.midan.repository.BookingRepository;
import com.example.midan.repository.GuestRepository;
import com.example.midan.repository.RoomRepository;
import com.example.midan.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, RoomRepository roomRepository, GuestRepository guestRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
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
    public Booking book(LocalDate checkIn, LocalDate checkOut, Long roomId, Long guestId) {
        Room room = this.roomRepository.findById(roomId).orElseThrow(InvalidRoomIdException::new);
        Guest guest = this.guestRepository.findById(guestId).orElseThrow(UserNotFoundException::new);
        Booking booking = new Booking(checkIn, checkOut, room, guest);
        return this.bookingRepository.save(booking);
    }


}
