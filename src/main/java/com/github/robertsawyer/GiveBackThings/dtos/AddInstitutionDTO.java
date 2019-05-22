package com.github.robertsawyer.GiveBackThings.dtos;

import com.github.robertsawyer.GiveBackThings.domain.model.Localization;
import com.github.robertsawyer.GiveBackThings.domain.model.Purpose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddInstitutionDTO {

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    private Localization localization;

    @NotNull
    private Purpose purpose;

    @NotNull
    @Size(min = 5, max = 600)
    private String decscription;


}
