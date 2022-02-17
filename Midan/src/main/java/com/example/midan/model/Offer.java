package com.example.midan.model;

import com.example.midan.model.Enumerations.OfferType;

import javax.persistence.*;

@Entity
public class Offer {

    public Offer() {
    }

    public Offer(String offerFor, String offerName, OfferType type) {
        this.offerFor = offerFor;
        this.offerName = offerName;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String offerFor; // za kogo ponuda

    private String offerName;

    @Enumerated
    private OfferType type;
}
