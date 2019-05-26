package com.github.robertsawyer.GiveBackThings.dtos;

import com.github.robertsawyer.GiveBackThings.domain.model.Address;
import com.github.robertsawyer.GiveBackThings.domain.model.Category;
import com.github.robertsawyer.GiveBackThings.domain.model.TrustedInstitution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddGiftFormDTO {

    @NotNull
    private List<Category> category;

    @NotNull
    private Integer bags;

    @NotNull
    private TrustedInstitution institution;

    @NotNull
    private Address address;

    @NotNull
    private String date;
}
