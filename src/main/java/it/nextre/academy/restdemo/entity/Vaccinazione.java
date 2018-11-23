package it.nextre.academy.restdemo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


/*
*
* Creo questa classe per aggiungere dei campi sulla tabella di relazione ManyToMany
*
* */


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="rel_vaccinazione")
public class Vaccinazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDateTime data_vaccino;
    private boolean pagato;

    @ManyToOne
    @JoinColumn(name = "fk_vaccino")
    private Vaccino vaccino;

    @ManyToOne
    @JoinColumn(name="fk_libretto")
    private Libretto libretto;
}//end class
