package com.github.robertsawyer.GiveBackThings.services;

import com.github.robertsawyer.GiveBackThings.domain.model.User;
import com.github.robertsawyer.GiveBackThings.domain.repositories.UserRepository;
import com.github.robertsawyer.GiveBackThings.dtos.DeleteUserDTO;
import com.github.robertsawyer.GiveBackThings.dtos.LoginFormDTO;
import com.github.robertsawyer.GiveBackThings.dtos.RegistrationFormDTO;
import com.github.robertsawyer.GiveBackThings.dtos.UserDTO;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class UserService {

    public UserService() {
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public UserDTO findUser(String login) {
        if (login == null) {
            throw new IllegalArgumentException("Nazwa użytkownika musi być podana");
        }
        Optional<User> optionalUser = userRepository.findByLogin(login);
        User user = optionalUser.orElse(null);

        if (user == null) {
            return null;
        }
        return Converters.convertToUserDTO(user);
    }

    @Transactional
    public void registerUser(RegistrationFormDTO formDTO) {
        User user = Converters.convertToUser(formDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User findExistingUser(LoginFormDTO loginUser) {
        User user = userRepository.findByEmail(loginUser.getEmail());
        if (!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
            return null;
        }
        return user;
    }

    public boolean checkIfRoleIsAdmin(LoginFormDTO loginFormDTO) {
        User user = userRepository.findByEmail(loginFormDTO.getEmail());
        if (user.getRole().equals("ADMIN")){
            return true;
        }
        return false;
    }

    public List<User> getAllAdmins() {
        List<User> admins = userRepository.findAllAdmins();
        return admins;
    }

    public List<User> getAllUser() {
        List<User> users = userRepository.findAllUsers();
        return users;
    }

    public void banUser() {
        // TODO: 12.05.19
    }


    public void deleteUser(DeleteUserDTO deleteUserDTO) {
        userRepository.delete(deleteUserDTO.getUserId());
    }
}
