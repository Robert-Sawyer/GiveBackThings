package com.github.robertsawyer.GiveBackThings.domain.repositories;

import com.github.robertsawyer.GiveBackThings.domain.model.User;
import com.github.robertsawyer.GiveBackThings.dtos.LoginFormDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    User findByEmail(String email);

    @Query(value = "SELECT * FROM users WHERE role = 'ADMIN'",
    nativeQuery = true)
    List<User> findAllAdmins();

    @Query(value = "SELECT * FROM users WHERE role = 'USER'",
    nativeQuery = true)
    List<User> findAllUsers();
}
