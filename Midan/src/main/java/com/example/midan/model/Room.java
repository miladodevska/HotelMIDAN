package com.example.midan.model;

import com.example.midan.model.Enumerations.RoomType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Room {

    public Room() {
    }
    public Room(String name, Double price, RoomType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    @Enumerated(EnumType.STRING)
    private RoomType type;
}
