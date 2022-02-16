package com.example.midan.service;

import com.example.midan.model.Employee;
import com.example.midan.model.Enumerations.GuestType;
import com.example.midan.model.Guest;

import java.util.List;

public interface GuestService {
    List<Guest> listAllGuests();
    Guest findById(Long id);
    Guest create(String name, String surname, String email, GuestType type);
    Guest update(Long id, String name, String surname, String email, GuestType type);
    Guest delete(Long id);
}
