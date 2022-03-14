package com.example.midan.web;


import com.example.midan.model.Enumerations.GuestType;
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
@RequestMapping("/guests")
public class GuestController {

    private final OfferService offerService;
    private final RoomService roomService;
    private final GuestService guestService;

    public GuestController(OfferService offerService,
                           RoomService roomService,
                           GuestService guestService) {
        this.offerService = offerService;
        this.roomService = roomService;
        this.guestService = guestService;
    }

    @GetMapping
    public String getGuestPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Guest> guests = this.guestService.listAllGuests();
        model.addAttribute("guests", guests);
        model.addAttribute("bodyContent", "guests");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGuest(@PathVariable Long id) {
        this.guestService.delete(id);
        return "redirect:/guests";
    }

    @GetMapping("/edit/{id}")
    public String editGuestPage(@PathVariable Long id, Model model) {
        if (this.guestService.findById(id) != null) { //? nemase isPresent() -- ne go dava u auto complete, znaci ne mozeme da stavime kje javuva greska
            Guest guest = this.guestService.findById(id);
            model.addAttribute("bodyContent", "add-guest");
            return "master-template";
        }
        return "redirect:/guests?error=OfferNotFound";
    }

    @GetMapping("/add-form")
    public String addGuestPage(Model model) {
        List<Room> rooms = this.roomService.listAllRooms();
        model.addAttribute("rooms", rooms);
        model.addAttribute("bodyContent", "add-guest");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveGuest(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam String email,
            @RequestParam GuestType type) {
        this.guestService.save(name, surname, email, type);
        return "redirect:/guests";
    }
}
