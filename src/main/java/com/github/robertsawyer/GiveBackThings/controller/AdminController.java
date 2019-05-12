package com.github.robertsawyer.GiveBackThings.controller;

import com.github.robertsawyer.GiveBackThings.dtos.DeleteUserDTO;
import com.github.robertsawyer.GiveBackThings.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/adminDashboard")
    public String showAdminMainPage(){
        return "admins/adminDashboard";
    }

    @GetMapping("/adminsList")
    public String showAdminsList(Model model){
        model.addAttribute("admins", userService.getAllAdmins());
        return "admins/adminsList";
    }

    @PostMapping(value = "/adminsList", params = "delete")
    public String deleteUser(@ModelAttribute("deleteAdmin") DeleteUserDTO deleteUserDTO){
        userService.deleteUser(deleteUserDTO);
        return "redirect:/adminsList";
    }
}
