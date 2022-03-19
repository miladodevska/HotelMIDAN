package com.example.midan.model;

import com.example.midan.model.Enumerations.GuestType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Guest {

    public Guest() {
    }

    public Guest(String name, String surname, String email, GuestType type) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.type = type;
    }

    public Guest(String name, String surname, String email, String phoneNumber, String gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public Guest(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String gender;

    private Integer roomNumber;
    // spored mene, ne treba da ima atribut roomNumber u klasata,
    // tuku da ima poseben model koj sto ke bide povrzan so modelot Guest so ManyToOne

    private Integer resides; //vreme na prestojuvanje vo denovi

    @Enumerated(EnumType.STRING)
    private GuestType type; // Tip na gostin

    @OneToOne //tuka mozda manytoone
    private Receipt receipt;

    private Integer numVisits = 0;


    void isVip() //ako br poseti >= 5 , gostin -> vip
    {
//        if (numVisits >= 5 || resides >= 30) {
//            this.type = GuestType.VIP;
//        } else {
//            this.type = GuestType.NORMAL;
//        }

        this.type = (numVisits >= 5 || resides >= 30) ? GuestType.VIP : GuestType.NORMAL;
    }

}
