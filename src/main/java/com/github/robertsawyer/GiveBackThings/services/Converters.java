package com.github.robertsawyer.GiveBackThings.services;

import com.github.robertsawyer.GiveBackThings.domain.model.Institution;
import com.github.robertsawyer.GiveBackThings.domain.model.Location;
import com.github.robertsawyer.GiveBackThings.domain.model.Purpose;
import com.github.robertsawyer.GiveBackThings.domain.model.User;
import com.github.robertsawyer.GiveBackThings.dtos.AddInstitutionDTO;
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
        user.setRole("USER");
        return user;
    }


    public static Institution convertToTrustedInstitution(AddInstitutionDTO newInstitution, Purpose purpose, Location location) {
        Institution institution = new Institution();
        institution.setName(newInstitution.getName());
        institution.setLocation(location);
        institution.setPurpose(purpose);
        institution.setDescription(newInstitution.getDecscription());
        return institution;
    }

}
