package com.example.midan.model;

import com.example.midan.model.Enumerations.OfferType;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
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


    private String offerFor; // za koja soba

    private String offerName;

    private Float offerPrice;

    @Enumerated(EnumType.STRING)
    private OfferType type;

//    @OneToMany(mappedBy = "offer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private List<Booking> bookings;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<ShoppingCart> shoppingCarts;
}
