package com.example.midan.repository;

import com.example.midan.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
    Optional<Guest> findByName(String username);

    Optional<Guest> findByUsername(String s);
}
