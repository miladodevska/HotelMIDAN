package com.example.midan.service.impl;

import com.example.midan.model.Enumerations.ShoppingCartStatus;
import com.example.midan.model.Exceptions.ProductAlreadyInShoppingCartException;
import com.example.midan.model.Exceptions.ShoppingCartNotFound;
import com.example.midan.model.Exceptions.UserNotFoundException;
import com.example.midan.model.Guest;
import com.example.midan.model.Offer;
import com.example.midan.model.Room;
import com.example.midan.model.ShoppingCart;
import com.example.midan.repository.GuestRepository;
import com.example.midan.repository.ShoppingCartRepository;
import com.example.midan.service.OfferService;
import com.example.midan.service.RoomService;
import com.example.midan.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {


    private final ShoppingCartRepository shoppingCartRepository;
    private final GuestRepository guestRepository;
    private final OfferService offerService;
    private final RoomService roomService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, GuestRepository guestRepository, OfferService offerService, RoomService roomService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.guestRepository = guestRepository;
        this.offerService = offerService;
        this.roomService = roomService;
    }


    @Override
    public List<Offer> listAllOffersInShoppingCart(Long cartId) {
        if(!this.shoppingCartRepository.findById(cartId).isPresent())
            throw new ShoppingCartNotFound(cartId);
        return this.shoppingCartRepository.findById(cartId).get().getOffers();
    }

    @Override
    public List<Room> listAllRoomsInShoppingCart(Long cartId) {
        if(!this.shoppingCartRepository.findById(cartId).isPresent())
            throw new ShoppingCartNotFound(cartId);
        return this.shoppingCartRepository.findById(cartId).get().getRooms();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        Guest user = this.guestRepository.findByName(username)
                .orElseThrow(UserNotFoundException::new);

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

    @Override
    public ShoppingCart addRoomToShoppingCart(String username, Long roomId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Room room = this.roomService.findById(roomId);

        if(shoppingCart.getRooms()
                .stream().filter(i -> i.getId().equals(roomId))
                .collect(Collectors.toList()).size() > 0)
            throw new ProductAlreadyInShoppingCartException(roomId, username);
        shoppingCart.getRooms().add(room);
        return this.shoppingCartRepository.save(shoppingCart);
    }


}
