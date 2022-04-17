package com.example.midan.service;

import com.example.midan.model.Offer;
import com.example.midan.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<Offer> listAllOffersInShoppingCart(Long cartId);
    ShoppingCart getActiveShoppingCart(String username);
    ShoppingCart addOfferToShoppingCart(String username, Long productId);
}
