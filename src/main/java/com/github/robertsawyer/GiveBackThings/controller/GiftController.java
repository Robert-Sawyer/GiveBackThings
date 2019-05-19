package com.github.robertsawyer.GiveBackThings.controller;

import com.github.robertsawyer.GiveBackThings.dtos.*;
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
    public String showAddGiftFormStepTwo(Model model){
        model.addAttribute("stepTwo", new AddGiftStepTwoDTO());
        return "gifts/giveAGiftStepTwo";
    }

    @PostMapping("/gifts/add/stepTwo")
    public String goToStepThree(@Valid @ModelAttribute("stepTwo") AddGiftStepTwoDTO addGiftStepTwoDTO, BindingResult result){
        if (result.hasErrors()){
            return "gifts/giveAGiftStepTwo";
        }

        return "redirect:/gifts/add/stepThree";
    }

    @GetMapping("/gifts/add/stepThree")
    public String showAddGiftFormStepThree(Model model){
        model.addAttribute("stepThree", new AddGiftStepThreeDTO());
        return "gifts/giveAGiftStepThree";
    }

    @PostMapping("/gifts/add/stepThree")
    public String goToStepFour(@Valid @ModelAttribute("stepThree") AddGiftStepThreeDTO addGiftStepThreeDTO, BindingResult result){
        if (result.hasErrors()){
            return "gifts/giveAGiftStepThree";
        }

        return "redirect:/gifts/add/stepFour";
    }

    @GetMapping("/gifts/add/stepFour")
    public String showAddGiftFormStepFour(){

        return "gifts/giveAGiftStepFour";
    }

    @PostMapping("/gifts/add/stepFour")
    public String goToStepFive(@Valid @ModelAttribute("stepFour") AddGiftStepFourDTO addGiftStepFourDTO, BindingResult result){
        if (result.hasErrors()){
            return "gifts/giveAGiftStepFour";
        }

        return "redirect:/gifts/add/stepFive";
    }

    @GetMapping("/gifts/add/stepFive")
    public String showAddGiftFormStepFive(){

        return "gifts/giveAGiftStepFive";
    }

    @PostMapping("/gifts/add/stepFive")
    public String goToStepSix(@Valid @ModelAttribute("stepFive") AddGiftStepFiveDTO addGiftStepFiveDTO, BindingResult result){
        if (result.hasErrors()){
            return "gifts/giveAGiftStepFive";
        }

        return "redirect:/gifts/add/stepSix";
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
