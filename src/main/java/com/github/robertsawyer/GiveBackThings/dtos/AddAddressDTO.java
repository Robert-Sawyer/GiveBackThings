package com.github.robertsawyer.GiveBackThings.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.util.calendar.BaseCalendar;

import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressDTO {

    @NotNull
    private String street;

    @NotNull
    private String town;

    @NotNull
    private String postcode;

    @NotNull
    private String date;

    @NotNull
    private Long phoneNumber;

    private String note;

}
