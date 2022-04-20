package com.example.midan.service.impl;

import com.example.midan.model.Enumerations.GuestType;
import com.example.midan.model.Exceptions.*;
import com.example.midan.model.Guest;
import com.example.midan.repository.GuestRepository;
import com.example.midan.service.GuestService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;
    private final PasswordEncoder passwordEncoder;

    public GuestServiceImpl(GuestRepository guestRepository, PasswordEncoder passwordEncoder) {
        this.guestRepository = guestRepository;
        this.passwordEncoder = passwordEncoder;
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
    public Optional<Guest> save(String name, String surname, String email, GuestType type) {
        return Optional.of(this.guestRepository.save(new Guest(name, surname, email, type)));

    }

    @Override
    public Guest create(String name, String surname, String email, GuestType type) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Guest g = new Guest(name, surname, email, type);
        guestRepository.save(g);
        return g;
    }

    @Override
    public Guest update(Long id, String name, String surname, String email, GuestType type) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Guest g = new Guest(name, surname, email, type);
        guestRepository.save(g);
        return g;
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        this.guestRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return guestRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(s));
    }

//    @Override
//    public Guest login(String username, String password) {
//        //Spring security
//        if(username==null || username.isEmpty() || password==null || password.isEmpty()){
//            throw new InvalidArgumentsException();
//        }
//        return (Guest) guestRepository.findByUsernameAndPassword(username,password)
//                .orElseThrow(InvalidGuestCredentialException::new);
//    }
//
    @Override
    public Guest register(String username, String email, String name, String surname, String password, String repeatPassword) {
        //Standardna forma so baza
        if(username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidUsernameOrPasswordException();
        }
        if(!password.equals(repeatPassword)){
            throw new PasswordDoNotMatchException();
        }

        if(this.guestRepository.findByUsername(username).isPresent()){
            throw new UsernameAlreadyExistException(username);
        }
        Guest guest = new Guest(username,passwordEncoder.encode(password),name,surname);
        return guestRepository.save(guest);
    }


}
