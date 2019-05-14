package com.github.robertsawyer.GiveBackThings.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "trusted_institutions")
public class TrustedInstitution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
