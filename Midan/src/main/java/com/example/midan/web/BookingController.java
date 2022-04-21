package com.example.midan.web;

import com.example.midan.model.Booking;
import com.example.midan.model.Enumerations.RoomType;
import com.example.midan.model.Guest;
import com.example.midan.model.Room;
import com.example.midan.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public String getBookingPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Booking> bookings = this.bookingService.listAllBookings();
        model.addAttribute("bookings", bookings);
        model.addAttribute("bodyContent", "rooms");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBooking(@PathVariable Long id) {
        this.bookingService.delete(id);
        return "redirect:/shopping-cart";
    }


    @PostMapping("/add")
    public String saveBooking(
           @RequestParam LocalDate checkIn,
           @RequestParam LocalDate checkOut,
           @RequestParam LocalDate bookingDate,
           @RequestParam boolean paymentStatus,
           @RequestParam boolean bookingStatus) {
        this.bookingService.save(checkIn, checkOut, bookingDate, paymentStatus, bookingStatus);
        return "redirect:/receipts";
    }
}
