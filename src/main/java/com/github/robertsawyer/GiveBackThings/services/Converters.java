package com.github.robertsawyer.GiveBackThings.services;

import com.github.robertsawyer.GiveBackThings.domain.model.User;
import com.github.robertsawyer.GiveBackThings.dtos.RegistrationFormDTO;
import com.github.robertsawyer.GiveBackThings.dtos.UserDTO;

public class Converters {

    public static UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(user.getLogin());
        return userDTO;
    }

    public static User convertToUser(RegistrationFormDTO formDTO) {
        User user = new User();
        user.setLogin(formDTO.getLogin());
        user.setEmail(formDTO.getEmail());
        user.setPassword(formDTO.getPassword());
        user.setFirstName(formDTO.getFirstName());
        user.setLastName(formDTO.getLastName());
        return user;
    }
}
