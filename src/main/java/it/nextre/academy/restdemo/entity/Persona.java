package it.nextre.academy.restdemo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="persona")
public class Persona {
    @Id
    private long id;
    private String nome;
    private int anno_di_nascita;
    @OneToMany(mappedBy = "fk_persona")
    private List<Animale> animali = new ArrayList<>();

}//end class
