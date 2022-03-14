package com.example.midan.web;

import com.example.midan.model.Enumerations.OfferType;
import com.example.midan.model.Guest;
import com.example.midan.model.Offer;
import com.example.midan.model.Room;
import com.example.midan.service.GuestService;
import com.example.midan.service.OfferService;
import com.example.midan.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final RoomService roomService;
    private final GuestService guestService;

    public OfferController(OfferService offerService,
                           RoomService roomService,
                           GuestService guestService) {
        this.offerService = offerService;
        this.roomService = roomService;
        this.guestService = guestService;
    }

    @GetMapping
    public String getOfferPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Offer> offers = this.offerService.listAllOffers();
        model.addAttribute("offers", offers);
        model.addAttribute("bodyContent", "offers");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOffer(@PathVariable Long id) {
        this.offerService.delete(id);
        return "redirect:/offers";
    }

    @GetMapping("/edit/{id}")
    public String editOfferPage(@PathVariable Long id, Model model) {
        if (this.offerService.findById(id) != null) { //? nemase isPresent() -- ne go dava u auto complete, znaci ne mozeme da stavime kje javuva greska
            Offer offer = this.offerService.findById(id);
            List<Room> rooms = this.roomService.listAllRooms();
            List<Guest> guests = this.guestService.listAllGuests();
            model.addAttribute("rooms", rooms);
            model.addAttribute("guests", guests);
            model.addAttribute("offer", offer);
            model.addAttribute("bodyContent", "add-offer");
            return "master-template";
        }
        return "redirect:/offers?error=OfferNotFound";
    }

    @GetMapping("/add-form")
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addOfferPage(Model model) {
        List<Room> rooms = this.roomService.listAllRooms();
        List<Guest> guests = this.guestService.listAllGuests();// zaso ima gosti u ponudite?
        model.addAttribute("rooms", rooms);
        model.addAttribute("guests", guests);
        model.addAttribute("bodyContent", "add-offer");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveOffer(
            @RequestParam(required = false) Long id,
            @RequestParam String offerFor,
            @RequestParam String offerName,
            @RequestParam OfferType type) {
        this.offerService.save(offerFor, offerName, type);
        return "redirect:/offers";
    }
}
