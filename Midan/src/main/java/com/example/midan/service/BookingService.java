package com.example.midan.service;

import com.example.midan.model.Booking;
import com.example.midan.model.Employee;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    List<Booking> listAllEmployees();

    Booking findById(Long id);

    Booking create(Integer days, LocalDate date);

    Booking update(Long id, Integer days, LocalDate date);

    Booking delete(Long id);
}
