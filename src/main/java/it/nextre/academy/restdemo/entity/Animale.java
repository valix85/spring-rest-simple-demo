package it.nextre.academy.restdemo.entity;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="animale")
public class Animale {
    @Id
    private long id;
    private String name;
    @ManyToOne
    //@Column(name="fk_persona")
    private Persona fk_persona;

}//end class
