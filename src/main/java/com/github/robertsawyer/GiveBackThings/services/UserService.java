package com.github.robertsawyer.GiveBackThings.services;

import com.github.robertsawyer.GiveBackThings.domain.model.User;
import com.github.robertsawyer.GiveBackThings.domain.repositories.UserRepository;
import com.github.robertsawyer.GiveBackThings.dtos.RegistrationFormDTO;
import com.github.robertsawyer.GiveBackThings.dtos.UserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

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
}
