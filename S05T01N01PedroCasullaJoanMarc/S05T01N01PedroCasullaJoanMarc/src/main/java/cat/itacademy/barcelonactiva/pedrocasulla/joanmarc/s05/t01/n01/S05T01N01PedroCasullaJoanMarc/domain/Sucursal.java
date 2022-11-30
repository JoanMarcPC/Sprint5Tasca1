package cat.itacademy.barcelonactiva.pedrocasulla.joanmarc.s05.t01.n01.S05T01N01PedroCasullaJoanMarc.domain;



import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString// @ToString, @EqualsAndHashCode, @Getter @Setter, and @RequiredArgsConstructor
@Entity// indica que serà persistent
@Table(name = "Sucursals")
@NoArgsConstructor
// itli for, iter forecah, sout print
public class Sucursal {
    @Id //define primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // per definir com es tractarà la primary key
    private long id;

    @Column(name = "name", length = 100) //atribut que serà columna a la db
    private String name;

    @Column(name = "country")
    private String country;

    public Sucursal(String name, String country) {
        this.name = name;
        this.country = country;

    }

}
