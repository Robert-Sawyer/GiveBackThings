package com.github.robertsawyer.GiveBackThings.controller;

import com.github.robertsawyer.GiveBackThings.dtos.DeleteInstitutionDTO;
import com.github.robertsawyer.GiveBackThings.services.TrustedInstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

}
