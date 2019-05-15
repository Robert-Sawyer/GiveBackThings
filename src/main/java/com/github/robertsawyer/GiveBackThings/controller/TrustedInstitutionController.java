package com.github.robertsawyer.GiveBackThings.controller;

import com.github.robertsawyer.GiveBackThings.dtos.AddInstitutionDTO;
import com.github.robertsawyer.GiveBackThings.dtos.DeleteInstitutionDTO;
import com.github.robertsawyer.GiveBackThings.services.TrustedInstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TrustedInstitutionController {

    private TrustedInstitutionService trustedInstitutionService;

    public TrustedInstitutionController(TrustedInstitutionService trustedInstitutionService) {
        this.trustedInstitutionService = trustedInstitutionService;
    }

    @GetMapping("/trustedInstitutions")
    public String showInstitutionsList(Model model){
        model.addAttribute("institutions", trustedInstitutionService.getAllTrustedIntitutions());
        return "trustedInstitutions/trustedInstitutionsList";
    }

    @PostMapping(value = "/trustedIntitutions", params = "delete")
    public String deleteInstitution(@ModelAttribute("deleteIntitution") DeleteInstitutionDTO deleteInstitutionDTO){
        trustedInstitutionService.deleteInstitution(deleteInstitutionDTO);
        return "redirect:/trustedInstitutions";
    }

    @GetMapping("/institution/add")
    public String showAddInstitutionForm(Model model){
        model.addAttribute("newInstitution", new AddInstitutionDTO());
        model.addAttribute("localization", trustedInstitutionService.getLocalization());
        model.addAttribute("purposes", trustedInstitutionService.getAllPurposes());
        return "trustedInstitutions/addNewTrustedInstitution";
    }

    @PostMapping("/institution/add")
    public String addNewInstitution(@Valid @ModelAttribute("newInstitution") AddInstitutionDTO newInstitution, BindingResult result){
        if (result.hasErrors()){
            return "trustedInstitutions/addNewTrustedInstitution";
        }
        trustedInstitutionService.createNewInstitution(newInstitution);
        return "redirect:/trustedInstitutions";
    }


}
