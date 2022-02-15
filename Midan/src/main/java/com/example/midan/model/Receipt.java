package com.example.midan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Receipt {
    @Id
    @GeneratedValue
    Long id;
    int roomNumber;
    Guest forUser;
    double price;
}
