package com.example.midan.model;

import com.example.midan.model.Enumerations.OfferType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
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
    private Float offerPrice;

    @Enumerated(EnumType.STRING)
    private OfferType type;


    @OneToMany(mappedBy = "offer")
    private List<Booking> bookings;
}
