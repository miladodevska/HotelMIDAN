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

    @ManyToOne
    private Guest guest;

    @OneToMany(mappedBy = "receipt", fetch = FetchType.EAGER)
    private List<Room> room;

    private Double price;


}
