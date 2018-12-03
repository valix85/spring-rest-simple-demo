package it.nextre.academy.restdemo.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="ruolo")
@Data //Constuctor NoArgs,Getter,Setter,Equals,Hashcode
public class Ruolo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ruolo_id")
    private int id;
    @Column(name = "ruolo")
    private String ruolo;
}//end class
