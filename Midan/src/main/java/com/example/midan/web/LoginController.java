package com.example.midan.web;

import com.example.midan.model.Employee;
import com.example.midan.model.Exceptions.InvalidGuestCredentialException;
import com.example.midan.model.Guest;
import com.example.midan.service.GuestService;
import com.example.midan.service.OfferService;
import com.example.midan.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final GuestService guestService;


    public LoginController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public String getLoginPage(Model model)
    {
        model.addAttribute("bodyContent","login");
        return "master-template";
    }


}
