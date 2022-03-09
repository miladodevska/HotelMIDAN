package com.example.midan.model;

import com.example.midan.model.Enumerations.OfferType;
import lombok.Data;

import javax.persistence.*;

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

    @Enumerated(EnumType.STRING)
    private OfferType type;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getOfferFor() {return offerFor;}

    public void setOfferFor(String offerFor) {this.offerFor = offerFor;}

    public String getOfferName() {return offerName;}

    public void setOfferName(String offerName) {this.offerName = offerName;}

    public OfferType getType() {return type;}

    public void setType(OfferType type) {this.type = type;}
}
