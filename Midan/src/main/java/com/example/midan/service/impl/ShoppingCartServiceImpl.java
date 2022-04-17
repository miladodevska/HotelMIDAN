package com.example.midan.service.impl;

import com.example.midan.model.Enumerations.ShoppingCartStatus;
import com.example.midan.model.Exceptions.OfferNotFoundException;
import com.example.midan.model.Exceptions.ProductAlreadyInShoppingCartException;
import com.example.midan.model.Exceptions.ShoppingCartNotFound;
import com.example.midan.model.Guest;
import com.example.midan.model.Offer;
import com.example.midan.model.ShoppingCart;
import com.example.midan.repository.GuestRepository;
import com.example.midan.repository.ShoppingCartRepository;
import com.example.midan.service.OfferService;
import com.example.midan.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {


    private final ShoppingCartRepository shoppingCartRepository;
    private final GuestRepository guestRepository;
    private final OfferService offerService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, GuestRepository guestRepository, OfferService offerService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.guestRepository = guestRepository;
        this.offerService = offerService;
    }


    @Override
    public List<Offer> listAllOffersInShoppingCart(Long cartId) {
        if(!this.shoppingCartRepository.findById(cartId).isPresent())
            throw new ShoppingCartNotFound(cartId);
        return this.shoppingCartRepository.findById(cartId).get().getOffers();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        Guest user = this.guestRepository.findByUsername(username)
                .orElseThrow(() -> new OfferNotFoundException());

        return this.shoppingCartRepository.findByGuestAndStatus(user, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    ShoppingCart cart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(cart);
                });
    }

    @Override
    public ShoppingCart addOfferToShoppingCart(String username, Long offerId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Offer offer = this.offerService.findById(offerId);

        if(shoppingCart.getOffers()
                .stream().filter(i -> i.getId().equals(offerId))
                .collect(Collectors.toList()).size() > 0)
            throw new ProductAlreadyInShoppingCartException(offerId, username);
        shoppingCart.getOffers().add(offer);
        return this.shoppingCartRepository.save(shoppingCart);
    }


}
