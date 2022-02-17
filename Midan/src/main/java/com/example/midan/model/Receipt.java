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


}
