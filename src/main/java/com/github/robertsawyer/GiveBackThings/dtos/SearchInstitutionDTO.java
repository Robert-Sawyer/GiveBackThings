package com.github.robertsawyer.GiveBackThings.dtos;

import com.github.robertsawyer.GiveBackThings.domain.model.Location;
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
    private Location Location;
    @NotNull
    private List<Purpose> purpose;

}
