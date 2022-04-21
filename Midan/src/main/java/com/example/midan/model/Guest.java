package com.example.midan.model;

import com.example.midan.model.Enumerations.GuestType;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity
public class Guest implements UserDetails {

    public Guest() {
    }

    public Guest(String name, String surname, String email, GuestType type) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.type = type;
    }

    public Guest(String name, String surname, String email, String phoneNumber, String gender, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }

    public Guest(String username, String password,String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String gender;

    private String username;
    private String password;

    @ManyToOne
    private Room room;

    private Integer resides; //vreme na prestojuvanje vo denovi

    @Enumerated(EnumType.STRING)
    private GuestType type; // Tip na gostin

    @OneToMany(mappedBy = "guest")
    private List<Receipt> receipt;

    @OneToMany(mappedBy = "guest")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "guest")
    private List<ShoppingCart> carts;

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


    private boolean isAccountNonExpired = true;

    private boolean isAccountNonLocked = true;

    private boolean isCredentialsExpired = true;

    private boolean isEnabled = true;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
