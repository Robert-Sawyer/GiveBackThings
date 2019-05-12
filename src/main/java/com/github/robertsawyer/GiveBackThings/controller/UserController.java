package com.github.robertsawyer.GiveBackThings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/userDashboard")
    public String showUserMainPage(){
        return "users/userDashboard";
    }

}
