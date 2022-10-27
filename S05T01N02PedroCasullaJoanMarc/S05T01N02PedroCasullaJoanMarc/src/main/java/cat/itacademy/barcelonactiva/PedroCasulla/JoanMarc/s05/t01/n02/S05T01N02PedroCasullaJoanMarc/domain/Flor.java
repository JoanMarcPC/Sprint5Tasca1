package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n02.S05T01N02PedroCasullaJoanMarc.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString// @ToString, @EqualsAndHashCode, @Getter @Setter, and @RequiredArgsConstructor
@Entity// indica que serà persistent
@Table(name = "Flors")
@NoArgsConstructor
// itli for, iter forecah, sout print
public class Flor {
    @Id //define primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // per definir com es tractarà la primary key
    private long id;

    @Column(name = "name", length = 100) //atribut que serà columna a la db
    private String name;

    @Column(name = "country")
    private String country;

    public Flor(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
