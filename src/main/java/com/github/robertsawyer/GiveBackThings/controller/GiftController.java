package com.github.robertsawyer.GiveBackThings.controller;

import com.github.robertsawyer.GiveBackThings.dtos.*;
import com.github.robertsawyer.GiveBackThings.services.InstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class GiftController {

    private InstitutionService institutionService;

    public GiftController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/gifts/add")
    public String showAddGiftForm(Model model){
        model.addAttribute("addGift", new AddGiftFormDTO());
        model.addAttribute("findProperInstitution", new SearchInstitutionDTO());
        model.addAttribute("locations", institutionService.getLocalization());
        model.addAttribute("purposes", institutionService.getPurposes());
        model.addAttribute("institutions", institutionService.getAllInstitutions());
        return "gifts/giveAGiftForm";
    }

    @PostMapping("/gifts/add")
    public String giveAway(@Valid @ModelAttribute("addGift") AddGiftFormDTO addGiftFormDTO, BindingResult result){
        if (result.hasErrors()){
            return "gifts/giveAGiftForm";
        }

        return "redirect:/gifts/done";
    }




}
