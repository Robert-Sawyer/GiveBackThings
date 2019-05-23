package com.github.robertsawyer.GiveBackThings.controller;

import com.github.robertsawyer.GiveBackThings.dtos.RegistrationFormDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistrationControllerTest {

    @Test
    public void shouldComparePassword(){
        RegistrationFormDTO dto = new RegistrationFormDTO();
        dto.setPassword("abcd");
        dto.setConfirmPassword("abcd");
        RegistrationController controller = new RegistrationController();
        boolean checkPasswordEquality = controller.checkPasswordEquality(dto);
        assertEquals(true, checkPasswordEquality);
    }

}