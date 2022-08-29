package projektindywidualny.projektindywidualny.Domain;

import com.vaadin.flow.router.Route;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Zajecie {
   private String autor;
   private int  dlugosc;
   private String materialy;
   private String opis;

   public String getAutor() {
      return autor;
   }

   public int getDlugosc() {
      return dlugosc;
   }

   public String getMaterialy() {
      return materialy;
   }

   public String getOpis() {
      return opis;
   }

}
