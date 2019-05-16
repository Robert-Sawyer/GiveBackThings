package com.github.robertsawyer.GiveBackThings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GiftController {


    @GetMapping("/gifts/add/stepOne")
    public String showAddGiftFormStepOne(){

        return "gifts/giveAGiftStepOne";
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
