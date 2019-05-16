package com.github.robertsawyer.GiveBackThings.controller;

import com.github.robertsawyer.GiveBackThings.dtos.AddGiftStepOneDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class GiftController {


    @GetMapping("/gifts/add/stepOne")
    public String showAddGiftFormStepOne(Model model){
        model.addAttribute("stepOne", new AddGiftStepOneDTO());
        return "gifts/giveAGiftStepOne";
    }

    @PostMapping("/gifts/add/stepOne")
    public String goToStepTwo(@Valid @ModelAttribute("stepOne") AddGiftStepOneDTO addGiftStepOneDTO, BindingResult result){
        if (result.hasErrors()){
            return "gifts/giveAGiftStepOne";
        }

        return "redirect:/gifts/add/stepTwo";
    }


    @GetMapping("/gifts/add/stepTwo")
    public String showAddGiftFormStepTwo(){

        return "gifts/giveAGiftStepTwo";
    }


    @GetMapping("/gifts/add/stepThree")
    public String showAddGiftFormStepThree(){

        return "gifts/giveAGiftStepThree";
    }


    @GetMapping("/gifts/add/stepFour")
    public String showAddGiftFormStepFour(){

        return "gifts/giveAGiftStepFour";
    }


    @GetMapping("/gifts/add/stepFive")
    public String showAddGiftFormStepFive(){

        return "gifts/giveAGiftStepFive";
    }


    @GetMapping("/gifts/add/stepSix")
    public String showAddGiftFormStepSix(){

        return "gifts/giveAGiftStepSix";
    }


    @GetMapping("/gifts/add/stepSeven")
    public String showAddGiftFormStepSeven(){

        return "gifts/giveAGiftStepSeven";
    }

}
