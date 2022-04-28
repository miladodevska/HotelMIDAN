package com.example.midan.web;

import com.example.midan.model.Guest;
import com.example.midan.model.ShoppingCart;
import com.example.midan.service.OfferService;
import com.example.midan.service.ShoppingCartService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final OfferService offerService;

    public ShoppingCartController(ShoppingCartService shoppingCartService, OfferService offerService) {
        this.shoppingCartService = shoppingCartService;
        this.offerService = offerService;
    }

    @GetMapping
    public String getShoppingCartPage(@RequestParam(required = false) String error,HttpServletRequest req, Model model) {
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        String username = req.getRemoteUser();
        ShoppingCart shoppingCart = this.shoppingCartService.getActiveShoppingCart(username);
        model.addAttribute("offers", this.shoppingCartService.listAllOffersInShoppingCart(shoppingCart.getId()));
        model.addAttribute("rooms", this.shoppingCartService.listAllRoomsInShoppingCart(shoppingCart.getId()));
        model.addAttribute("bodyContent","shoppingCart");
        return "master-template";
    }

    @PostMapping("/add-offer/{id}")
    public String addOfferToShoppingCart(@PathVariable Long id, HttpServletRequest req, Authentication authentication) {
        try{
            Guest guest = (Guest) authentication.getPrincipal();
            this.shoppingCartService.addOfferToShoppingCart(guest.getUsername(), id);
            return "redirect:/shoppingCart";
        }catch (RuntimeException exception) {
            return "redirect:/shoppingCart?error=" + exception.getMessage();
        }
    }

    @PostMapping("/add-room/{id}")
    public String addRoomToShoppingCart(@PathVariable Long id, HttpServletRequest req, Authentication authentication) {
        try{
            Guest guest = (Guest) authentication.getPrincipal();
            this.shoppingCartService.addRoomToShoppingCart(guest.getUsername(), id);
            return "redirect:/shoppingCart";
        }catch (RuntimeException exception) {
            return "redirect:/shoppingCart?error=" + exception.getMessage();
        }
    }
//    @PostMapping("/bookOffer/{id}")
//    public String bookOffer(@PathVariable Long id, HttpServletRequest req, Authentication authentication) {
//        try{
//            Guest guest = (Guest) authentication.getPrincipal();
//            this.shoppingCartService.addOfferToShoppingCart(guest.getUsername(), id); //DA NE TREBA REQ.GETUSER()?
//            return "redirect:/shoppingCart";
//        }catch (RuntimeException exception) {
//            return "redirect:/shoppingCart?error=" + exception.getMessage();
//        }
//    }

}