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
public class AddGiftStepFiveDTO {

    @NotNull
    private String street;
    @NotNull
    private Integer houseNumber;
    private Integer apartmentNumber;
    @NotNull
    private String city;
    @NotNull
    private String postcode;
    @NotNull
    private BaseCalendar.Date date;
    private Time hour;
    @NotNull
    private Long phoneNumber;
    private String note;

}
