package com.github.robertsawyer.GiveBackThings.controller;

import com.github.robertsawyer.GiveBackThings.domain.model.User;
import com.github.robertsawyer.GiveBackThings.dtos.DeleteUserDTO;
import com.github.robertsawyer.GiveBackThings.dtos.EntitleAdminDTO;
import com.github.robertsawyer.GiveBackThings.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping(value = "/usersList", params = "entitle")
    public String entitleAdmin(@ModelAttribute("entitleUser") EntitleAdminDTO entitleAdmin) {
        userService.entitleAdmin(entitleAdmin);
        return "redirect:/adminsList";
    }

    @PostMapping(value = "/usersList", params = "delete")
    public String deleteUser(@ModelAttribute("deleteUser") DeleteUserDTO deleteUserDTO){
        userService.deleteUser(deleteUserDTO);
        return "redirect:/usersList";
    }

}
