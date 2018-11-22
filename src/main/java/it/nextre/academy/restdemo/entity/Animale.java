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
    @JoinColumn(name="fk_persona") //non posso usare @Column ma devo usare @JoinColumn
    private Persona fk_persona;
    @OneToOne(mappedBy = "animale" )
    private Libretto libretto;

}//end class
