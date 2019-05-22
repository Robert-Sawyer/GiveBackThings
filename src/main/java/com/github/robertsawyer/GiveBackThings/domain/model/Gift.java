package com.github.robertsawyer.GiveBackThings.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "gifts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Category> categories;

    @Column(nullable = false)
    private Long bags;

//    private Localization localization;

    private Purpose purpose;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private TrustedInstitution institution;

    @ManyToOne
    private Addres address;

    private LocalDateTime created;

    private BaseCalendar.Date date;


}
