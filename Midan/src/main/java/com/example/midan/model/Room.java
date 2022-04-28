package com.example.midan.model;

import com.example.midan.model.Enumerations.RoomType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Room {

    public Room() {
    }
    public Room(String name, Double price, RoomType type, String imageUrl) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.imageUrl = imageUrl;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private String imageUrl;

    @OneToMany(mappedBy = "room")
    private List<Guest> guestList;

    @ManyToOne
    private Receipt receipt;

    @Enumerated(EnumType.STRING)
    private RoomType type;

    @ManyToMany
    private List<ShoppingCart> shoppingCarts;


}
