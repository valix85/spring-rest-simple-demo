package it.nextre.academy.restdemo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString

@Entity
@Table(name="movie")
public class Movie {
    @Id
    private int mID;
    private String title;
    private Integer year;
    private String director;

}//end class

