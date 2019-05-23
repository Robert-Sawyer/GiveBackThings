package com.github.robertsawyer.GiveBackThings.controller;

import com.github.robertsawyer.GiveBackThings.domain.model.User;
import com.github.robertsawyer.GiveBackThings.dtos.RegistrationFormDTO;
import com.github.robertsawyer.GiveBackThings.dtos.UserDTO;
import com.github.robertsawyer.GiveBackThings.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    public RegistrationController() {
    }

    @Autowired
    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegisterForm(Model model){
        model.addAttribute("registrationForm", new RegistrationFormDTO());
        return "home/register";
    }

    @PostMapping
    public String register(@Valid @ModelAttribute("registrationForm") RegistrationFormDTO formDTO, BindingResult result, Principal principal){
        if(result.hasErrors()){
            return "home/register";
        }
        if(!checkPasswordEquality(formDTO)){
            result.rejectValue("password", null, "Hasło i powtórzone hasło nie mogą się różnić");
            return "home/register";
        }
        if(!checkLoginAvailable(formDTO)){
            result.rejectValue("login", null, "Nazwa użytkownika już zajęta");
            return "home/register";
        }
        userService.registerUser(formDTO);
        return "redirect:/home";
    }

    private boolean checkLoginAvailable(RegistrationFormDTO formDTO) {
        UserDTO userDTO = userService.findUser(formDTO.getLogin());
        if (userDTO == null){
            return true;
        }
        return false;
    }

    protected boolean checkPasswordEquality(RegistrationFormDTO formDTO) {
        return formDTO.getPassword().equals(formDTO.getConfirmPassword());
    }
}
