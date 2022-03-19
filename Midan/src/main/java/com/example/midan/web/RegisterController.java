package com.example.midan.web;


import com.example.midan.model.Exceptions.InvalidArgumentsException;
import com.example.midan.model.Exceptions.PasswordDoNotMatchException;
import com.example.midan.service.GuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final GuestService guestService;

    public RegisterController(GuestService guestService) {
        this.guestService = guestService;
    }

    //TEMPLEJTOT DA SE PROVERI !!!!!!!!!!!!!!!!!!!!!
    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model)
    {
        if(error!=null && !error.isEmpty())
        {
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        model.addAttribute("bodyContent","register");
        return "master-template"; // NEKOJ TEMPLEJT OD GOOGLE !!!!!!
    }

    @PostMapping
    public String register(@RequestParam String email,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword)
    {
        try{
            this.guestService.register(email,name,surname,password,repeatedPassword);
            return "redirect:/login";
        }
        catch (PasswordDoNotMatchException | InvalidArgumentsException exception)
        {
            return "redirect:/register?error="+exception.getMessage();
        }
    }



}
