package com.example.midan.model;

import com.example.midan.model.Enumerations.RoomType;

import javax.persistence.*;

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

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Double getPrice() {return price;}

    public void setPrice(Double price) {this.price = price;}

    public RoomType getType() {return type;}

    public void setType(RoomType type) {this.type = type;}

}
