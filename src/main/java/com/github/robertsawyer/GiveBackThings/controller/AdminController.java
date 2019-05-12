package com.github.robertsawyer.GiveBackThings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/adminDashboard")
    public String showAdminMainPage(){
        return "admins/adminDashboard";
    }
}
