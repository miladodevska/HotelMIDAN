package com.example.midan.repository;

import com.example.midan.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    Offer findByOfferName(String name);
    void deleteByOfferName(String name);
}
