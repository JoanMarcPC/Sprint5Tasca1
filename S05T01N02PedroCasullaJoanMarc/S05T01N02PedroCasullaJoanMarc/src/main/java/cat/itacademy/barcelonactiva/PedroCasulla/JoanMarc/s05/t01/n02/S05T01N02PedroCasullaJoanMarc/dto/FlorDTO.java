package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n02.S05T01N02PedroCasullaJoanMarc.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FlorDTO implements Serializable {
    private static final List<String> PAISOSUE = List.of("Spain", "France", "Germany", "Denmark", "Italy", "Greece", "Hungary");

    private long id;

    private String name;

    private String country;
    private String type;

    public void checkType() {
        if (PAISOSUE.contains(this.country)) {
            this.type = "UE";
        } else {
            this.type = "OUT UE";
        }
    }
}
