package com.github.robertsawyer.GiveBackThings.dtos;

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
    private String localization;
    @NotNull
    private String purpose;
    @NotNull
    @Size(min = 5, max = 600)
    private String decscription;


}
