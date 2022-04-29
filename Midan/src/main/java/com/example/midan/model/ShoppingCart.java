package com.example.midan.model;

import com.example.midan.model.Enumerations.ShoppingCartStatus;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Where(clause = "deleted=false")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataCreated;

    private Boolean deleted = false;

    @ManyToOne
    private Guest guest;

    @ManyToMany
    private List<Room> rooms;

//    @JoinTable(joinColumns = @JoinColumn(name = "shopping_cart_id"),
//            inverseJoinColumns = @JoinColumn(name = "offerId"))
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Offer> offers;

    @Enumerated(EnumType.STRING)
    private ShoppingCartStatus status;

    public ShoppingCart() {
    }

    public ShoppingCart(Guest guest) {
        this.dataCreated = LocalDateTime.now();
        this.guest = guest;
        this.offers = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.status = ShoppingCartStatus.CREATED;
    }
}
