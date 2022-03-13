package com.example.midan.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/home"})
public class MidanController {

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("bodyContent", "home"); //ic ne mi teknuva ova zaso bese vaka ama neka go
        return "";
       //TODO
    }

    @GetMapping("/access_denied")
    public String getAccessDeniedPage(Model model){
        model.addAttribute("bodyContent", "access_denied");
        return "";
        //TODO
    }

}
