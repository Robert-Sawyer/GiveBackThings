package com.github.robertsawyer.GiveBackThings.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchInstitutionDTO {

    private Long locationId;

    private Long purposeId;

}
