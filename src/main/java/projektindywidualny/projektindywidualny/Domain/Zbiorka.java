package projektindywidualny.projektindywidualny.Domain;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.textfield.TextField;
import lombok.*;
import org.springframework.context.annotation.Bean;
import projektindywidualny.projektindywidualny.typy.ZbiorkaType;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Zbiorka {
    private String autor;
    private String data;
    private String temat;
    private String materialy;
    private String komentarze;
    private String zajecia;

    private Integer czasZbiorki;

    private ZbiorkaType zatwierdzona;





   public Zbiorka(String autor, String data, String temat, String materialy, String komentarze, String zajecia, Integer czasZbiorki) {
        this.autor = autor;
        this.data = data;
        this.temat = temat;
        this.materialy = materialy;
        this.komentarze = komentarze;
        this.zajecia = zajecia;
        this.czasZbiorki = czasZbiorki;
    }

}
