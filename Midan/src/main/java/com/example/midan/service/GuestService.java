package com.example.midan.service;

import com.example.midan.model.Employee;
import com.example.midan.model.Guest;

import java.util.List;

public interface GuestService {
    List<Guest> listAllGuests();
    Guest findById(Long id);
    Guest create();
    Guest update();
    Guest delete(Long id);
}
