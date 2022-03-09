package com.example.midan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Receipt {

    public Receipt(){
    }

    public Receipt(Guest guest, List<Room> room, Double price){
        this.guest = guest;
        this.room = room;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Guest guest;

    @OneToMany
    private List<Room> room; //dali sigurno treba ova?

    private Double price;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Guest getGuest() {return guest;}

    public void setGuest(Guest guest) {this.guest = guest;}

    public List<Room> getRoom() {return room;}

    public void setRoom(List<Room> room) {this.room = room;}

    public Double getPrice() {return price;}

    public void setPrice(Double price) {this.price = price;}
}
