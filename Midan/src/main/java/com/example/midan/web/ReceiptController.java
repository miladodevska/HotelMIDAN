package com.example.midan.web;

import com.example.midan.model.Guest;
import com.example.midan.model.Receipt;
import com.example.midan.model.Room;
import com.example.midan.service.GuestService;
import com.example.midan.service.ReceiptService;
import com.example.midan.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/receipts")
public class ReceiptController {

    private final RoomService roomService;
    private final GuestService guestService;
    private final ReceiptService receiptService;

    public ReceiptController(RoomService roomService,
                             GuestService guestService,
                             ReceiptService receiptService) {
        this.roomService = roomService;
        this.guestService = guestService;
        this.receiptService = receiptService;
    }

    @GetMapping
    public String getReceiptPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Receipt> receipts = this.receiptService.listAllReceipts();
        model.addAttribute("receipts", receipts);
        model.addAttribute("bodyContent", "receipts");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteReceipt(@PathVariable Long id){
        this.receiptService.delete(id);
        return "redirect:/receipts";
    }

    @GetMapping("/edit/{id}")
    public String editReceiptPage(@PathVariable Long id, Model model){
        if (this.receiptService.findById(id) != null){
            List<Room> rooms = this.roomService.listAllRooms();
            List<Guest> guests= this.guestService.listAllGuests();
            model.addAttribute("rooms", rooms);
            model.addAttribute("guests", guests);
            model.addAttribute("bodyContent", "add-receipts");
            return "master-template";
        }
        return "redirect:/receipts?error=ReceiptNotFound";
    }

    @GetMapping("/add-form")
    public String addReceiptPage(Model model){
        List<Room> rooms = this.roomService.listAllRooms();
        List<Guest> guests= this.guestService.listAllGuests();
        model.addAttribute("rooms", rooms);
        model.addAttribute("guests", guests);
        model.addAttribute("bodyContent", "add-receipts");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveReceipt(
            @RequestParam(required = false) Long id,
            @RequestParam Guest guest,
            @RequestParam List<Room> room,
            @RequestParam Double price){
        this.receiptService.save(guest, room, price);
        return "redirect:/receipts";
    }
}
