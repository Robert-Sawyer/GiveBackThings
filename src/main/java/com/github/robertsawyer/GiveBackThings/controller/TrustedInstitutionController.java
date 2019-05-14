package com.github.robertsawyer.GiveBackThings.controller;

import com.github.robertsawyer.GiveBackThings.services.TrustedInstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrustedInstitutionController {

    private TrustedInstitutionService trustedInstitutionService;

    public TrustedInstitutionController(TrustedInstitutionService trustedInstitutionService) {
        this.trustedInstitutionService = trustedInstitutionService;
    }

    @GetMapping
    public String showInstitutionsList(Model model){
        model.addAttribute("institutions", trustedInstitutionService.getAllTrustedIntitutions());
        return "trustedInstitutions/trustedInstitutionsList";
    }
}
