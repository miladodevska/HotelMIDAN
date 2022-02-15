package com.example.midan.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Offer {
    @Id
    @GeneratedValue
    Long id;

    String offerFor; // za kogo ponuda
    String offerName;
    @Enumerated
    OfferType type;


    public Offer() {
    }
}
