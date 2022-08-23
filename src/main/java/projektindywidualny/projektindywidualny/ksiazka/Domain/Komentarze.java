package projektindywidualny.projektindywidualny.ksiazka.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Komentarze {
    String autor;
    String tresc;

    @Override
    public String toString() {
        return "Komentarze{" +
                "autor='" + autor + '\'' +
                ", tresc='" + tresc + '\'' +
                '}';
    }
}
