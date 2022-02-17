package com.example.midan.model;

import com.example.midan.model.Enumerations.GuestType;

import javax.persistence.*;

@Entity
public class Guest {

    public Guest() {
    }

    public Guest(String name, String surname, String email, Integer phoneNumber, String gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private Integer phoneNumber;

    private String gender;

    private Integer roomNumber;
    // spored mene, ne treba da ima atribut roomNumber u klasata,
    // tuku da ima poseben model koj sto ke bide povrzan so modelot Guest so ManyToOne

    private Integer resides; //vreme na prestojuvanje vo denovi

    @Enumerated
    private GuestType type; // Tip na gostin

    @OneToOne
    private Receipt receipt;

    private Integer numVisits = 0;


    void isVip() //ako br poseti >= 5 , gostin -> vip
    {
        if (numVisits >= 5 || resides >= 30) {
            this.type = GuestType.VIP;
        } else {
            this.type = GuestType.NORMAL;
        }
    }

}
