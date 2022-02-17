package com.example.midan.model;

import javax.persistence.*;

@Entity
public class Receipt {

    public Receipt(){
    }

    public Receipt(Integer roomNumber, Double price){
        this.roomNumber = roomNumber;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer roomNumber;

    private Double price;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Integer getRoomNumber() {return roomNumber;}

    public void setRoomNumber(Integer roomNumber) {this.roomNumber = roomNumber;}

    public Double getPrice() {return price;}

    public void setPrice(Double price) {this.price = price;}
}
