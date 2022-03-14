package com.example.midan.service;

import com.example.midan.model.Enumerations.GuestType;
import com.example.midan.model.Guest;

import java.util.List;
import java.util.Optional;

public interface GuestService {

    List<Guest> listAllGuests();

    Guest findById(Long id);

    Optional<Guest> save(String name, String surname, String email, GuestType type);

    Guest create(String name, String surname, String email, GuestType type);

    Guest update(Long id, String name, String surname, String email, GuestType type);

    void delete(Long id);
}
