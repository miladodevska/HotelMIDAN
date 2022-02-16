package com.example.midan.model;

import com.example.midan.model.Enumerations.OfferType;

import javax.persistence.*;

@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String offerFor; // za kogo ponuda

    private String offerName;

    @Enumerated
    private OfferType type;

    public Offer() {
    }
}
