package com.github.robertsawyer.GiveBackThings.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "purposes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purpose {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private List<Institution> institutions;

}
