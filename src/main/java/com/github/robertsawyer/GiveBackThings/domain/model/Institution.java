package com.github.robertsawyer.GiveBackThings.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "institutions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Location location;

    @ManyToOne
    private Purpose purpose;

    @Column(nullable = false)
    private String description;

}
