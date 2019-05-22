package com.github.robertsawyer.GiveBackThings.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Localization {

    private Long id;

    private String name;

    @OneToMany
    private List<TrustedInstitution> institutions;
}
