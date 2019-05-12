package com.github.robertsawyer.GiveBackThings.controller;

import com.github.robertsawyer.GiveBackThings.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userDashboard")
    public String showUserMainPage(){
        return "users/userDashboard";
    }

    @GetMapping("/usersList")
    public String showUsersList(Model model){
        model.addAttribute("users", userService.getAllUser());
        return "users/usersList";
    }

}
