package it.nextre.academy.restdemo.entity;


import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="vaccino")
public class Vaccino {

    @Id
    private long id;
    private String descrizione;
    @ManyToMany
    @JoinTable(
            name = "rel_libretto_vaccino",
            joinColumns = @JoinColumn(name="pk_id_vaccino"),
            inverseJoinColumns = @JoinColumn(name="pk_id_libretto")
    )
    private List<Libretto> libretto;


}//end class
