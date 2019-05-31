package com.github.robertsawyer.GiveBackThings.controller;

import com.github.robertsawyer.GiveBackThings.dtos.AddInstitutionDTO;
import com.github.robertsawyer.GiveBackThings.dtos.DeleteInstitutionDTO;
import com.github.robertsawyer.GiveBackThings.services.InstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class InstitutionController {

    private InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/institutions")
    public String showInstitutionsList(Model model){
        model.addAttribute("institutions", institutionService.getAllInstitutions());
        return "institutions/institutionsList";
    }

    @PostMapping(value = "/intitutions", params = "delete")
    public String deleteInstitution(@ModelAttribute("deleteIntitution") DeleteInstitutionDTO deleteInstitutionDTO){
        institutionService.deleteInstitution(deleteInstitutionDTO);
        return "redirect:/institutions";
    }

    @GetMapping("/institution/add")
    public String showAddInstitutionForm(Model model){
        model.addAttribute("newInstitution", new AddInstitutionDTO());
        model.addAttribute("localizations", institutionService.getLocalization());
        model.addAttribute("purposes", institutionService.getAllPurposes());
        return "institutions/addNewInstitution";
    }

    @PostMapping("/institution/add")
    public String addNewInstitution(@Valid @ModelAttribute("newInstitution") AddInstitutionDTO newInstitution, BindingResult result){
        if (result.hasErrors()){
            return "institutions/addNewInstitution";
        }
        institutionService.createNewInstitution(newInstitution);
        return "redirect:/institutions";
    }


}
