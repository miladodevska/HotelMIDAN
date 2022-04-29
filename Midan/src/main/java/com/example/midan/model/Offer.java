package com.example.midan.model;

import com.example.midan.model.Enumerations.OfferType;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Where(clause = "deleted=false")
public class Offer {

    public Offer() {
    }

    public Offer(String offerFor, String offerName, float offerPrice, OfferType type) {
        this.offerFor = offerFor;
        this.offerName = offerName;
        this.offerPrice = offerPrice;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean deleted=false;

    private String offerFor; // za koja soba

    private String offerName;

    private Float offerPrice;

    @Enumerated(EnumType.STRING)
    private OfferType type;


}
