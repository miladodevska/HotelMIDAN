package com.example.midan.model;

import com.example.midan.model.Enumerations.GuestType;

import javax.persistence.*;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private Integer roomNumber;

    private Integer resides; //vreme na prestojuvanje vo denovi

    @Enumerated
    private GuestType type; // Tip na gostin

    @OneToOne
    private Receipt receipt;

    private Integer numVisits = 0;

    public Guest() {
    }

    void isVip() //ako br poseti >= 5 , gostin -> vip
    {
        if (numVisits >= 5 || resides >= 30) {
            this.type = GuestType.VIP;
        } else {
            this.type = GuestType.NORMAL;
        }
    }

}
