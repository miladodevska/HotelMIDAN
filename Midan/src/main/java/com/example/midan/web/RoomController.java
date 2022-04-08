package com.example.midan.web;


import com.example.midan.model.Enumerations.OfferType;
import com.example.midan.model.Enumerations.RoomType;
import com.example.midan.model.Guest;
import com.example.midan.model.Receipt;
import com.example.midan.model.Room;
import com.example.midan.service.GuestService;
import com.example.midan.service.OfferService;
import com.example.midan.service.ReceiptService;
import com.example.midan.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;
    private final GuestService guestService;
    private final OfferService offerService;

    public RoomController(RoomService roomService,
                          GuestService guestService,
                          OfferService offerService) {
        this.roomService = roomService;
        this.guestService = guestService;
        this.offerService = offerService;
    }

    @GetMapping
    public String getRoomPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Room> rooms = this.roomService.listAllRooms();
        model.addAttribute("rooms", rooms);
        model.addAttribute("bodyContent", "rooms");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        this.roomService.delete(id);
        return "redirect:/rooms";
    }

    @GetMapping("/edit/{id}")
    public String editReceiptPage(@PathVariable Long id, Model model) {
        if (this.roomService.findById(id) != null) {
            List<Room> rooms = this.roomService.listAllRooms();
            List<Guest> guests = this.guestService.listAllGuests();
            model.addAttribute("rooms", rooms);
            model.addAttribute("guests", guests);
            model.addAttribute("bodyContent", "add-room");
            return "master-template";
        }
        return "redirect:/rooms?error=RoomNotFound";
    }

    @GetMapping("/add-form")
    public String addRoomPage(Model model) {
        List<Room> rooms = this.roomService.listAllRooms();
        List<Guest> guests = this.guestService.listAllGuests();
        model.addAttribute("rooms", rooms);
        model.addAttribute("guests", guests);
        model.addAttribute("bodyContent", "add-room");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveRoom(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam Double price,
            @RequestParam RoomType type,
            @RequestParam String imageUrl) {
        this.roomService.save(name, price, type, imageUrl);
        return "redirect:/rooms";
    }
}
