package com.github.robertsawyer.GiveBackThings.dtos;

import com.github.robertsawyer.GiveBackThings.domain.model.TrustedInstitution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddGiftStepFourDTO {

    @NotNull
    private TrustedInstitution institution;
}
