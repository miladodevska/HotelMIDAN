package com.example.midan.model;

import javax.persistence.*;

@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer roomNumber;

    private Double price;

    public Receipt(){
    }
}
