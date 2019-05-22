package com.github.robertsawyer.GiveBackThings.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trusted_institutions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrustedInstitution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @Column(nullable = false)
    private Localization localization;

    @OneToOne
    @Column(nullable = false)
    private Purpose purpose;

    @Column(nullable = false)
    private String description;
}
