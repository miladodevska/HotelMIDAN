package com.example.midan.repository;

import com.example.midan.model.Enumerations.ShoppingCartStatus;
import com.example.midan.model.Guest;
import com.example.midan.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    Optional<ShoppingCart> findByGuestAndStatus(Guest guest, ShoppingCartStatus shoppingCartStatus);
}
