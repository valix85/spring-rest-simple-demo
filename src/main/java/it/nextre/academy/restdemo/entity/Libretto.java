package it.nextre.academy.restdemo.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="libretto")
public class Libretto {

    @Id
    private long id;
    private String microchip;
    private String photo_url;
    //... and more
    @OneToOne
    @JoinColumn(name="fk_animale")
    private Animale animale;


    @ManyToMany(mappedBy = "libretto", fetch = FetchType.LAZY) //mappedBy non crea la tabella!
    private List<Vaccino> vaccino;

}//end class
