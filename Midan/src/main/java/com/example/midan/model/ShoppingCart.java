package com.example.midan.model;

import com.example.midan.model.Enumerations.ShoppingCartStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataCreated;
    @ManyToOne
    private Guest guest;
    @ManyToMany
    private List<Room> rooms;
    @ManyToMany
    private List<Offer> offers;
    @Enumerated(EnumType.STRING)
    private ShoppingCartStatus status;

    public ShoppingCart() {
    }

    public ShoppingCart(Guest guest) {
        this.dataCreated = LocalDateTime.now();
        this.guest = guest;
        this.offers = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.status = ShoppingCartStatus.CREATED;
    }
}
