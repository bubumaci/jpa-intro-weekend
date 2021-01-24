package com.codecool.jpaweekendintro.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Meeting {
    @Id
    @GeneratedValue
    Long id;
    String title;
    LocalDate date;
    String description;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<Participant> participantCollection;
}
