package com.github.robertsawyer.GiveBackThings.dtos;

import com.github.robertsawyer.GiveBackThings.domain.model.Localization;
import com.github.robertsawyer.GiveBackThings.domain.model.Purpose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchInstitutionDTO {

    @NotNull
    private Localization Localization;
    @NotNull
    private List<Purpose> purpose;

}
