package com.example.midan.service.impl;

import com.example.midan.model.Enumerations.GuestType;
import com.example.midan.model.Guest;
import com.example.midan.repository.GuestRepository;
import com.example.midan.service.GuestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public List<Guest> listAllGuests() {
        return this.guestRepository.findAll();
    }

    @Override
    public Guest findById(Long id) {
        return this.guestRepository.getById(id);
    }

    @Override
    public Guest create(String name, String surname, String email, GuestType type) {
        if(name==null || name.isEmpty()){
            throw new IllegalArgumentException();
        }
        Guest g = new Guest(name,surname,email,type);
        guestRepository.save(g);
        return g;
    }

    @Override
    public Guest update(Long id, String name, String surname, String email, GuestType type) {
        if(name==null || name.isEmpty()){
            throw new IllegalArgumentException();
        }
        Guest g = new Guest(name,surname,email,type);
        guestRepository.save(g);
        return g;
    }

    @Override
    public void delete(Long id) {
        if(id==null){
            throw new IllegalArgumentException();
        }
        this.guestRepository.deleteById(id);
    }
}
