package com.example.midan.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Guest {
    @Id
    @GeneratedValue
    Long QuestId;
    String name;
    String surname;
    int roomNumber;
    int resides; //vreme na prestojuvanje vo denovi
    @Enumerated
    GuestType type; // Tip na gostin
    int brPoseti = 0;

    public Guest() {
    }

    void isVip() //ako br poseti >= 5 , gostin -> vip
    {
        if(brPoseti>=5 || resides >= 30)
        {
            this.type = GuestType.VIP;
        }
        else
        {
            this.type = GuestType.NORMAL;
        }
    }

}
