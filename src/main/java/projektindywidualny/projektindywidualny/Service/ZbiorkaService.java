package projektindywidualny.projektindywidualny.Service;


import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import projektindywidualny.projektindywidualny.ksiazka.Domain.Komentarze;
import projektindywidualny.projektindywidualny.ksiazka.Domain.Zajecie;
import projektindywidualny.projektindywidualny.ksiazka.Domain.Zbiorka;

import java.awt.event.TextEvent;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
@Route
public class ZbiorkaService {
    private Set<Zbiorka> zbiorki;
    private static ZbiorkaService zbiorkaService;
    private TextField textField;


    private ZbiorkaService() {
        this.zbiorki = exampleZbiorki();
    }
    public static ZbiorkaService getInstance(){
        if (zbiorkaService==null){
            zbiorkaService = new ZbiorkaService();
        }
        return zbiorkaService;
    }
    public  Set <Zbiorka>  getZbiorki(){
        return zbiorki;
    }
    public void addZbiorki(Zbiorka zbiorka) {this.zbiorki.add(zbiorka);
    }
    public Set <Zbiorka> findByAutor(String autor){
        return zbiorki.stream()
                .filter(zbiorka->zbiorka.getAutor().toLowerCase().contains(autor.toLowerCase()))
                .collect(Collectors.toSet());
    }

    private Set<Zbiorka> exampleZbiorki() {
     //tu dać  zapytania HTTP

    Set <Zbiorka> zbiorki = new HashSet<>();
    Komentarze kometarz1 = new Komentarze("Drużynowa","Komentarz nr 1");
    Komentarze kometarz2 = new Komentarze("Drużynowa","Komentarz nr 2");


    Zajecie zajecie1 = new Zajecie("Justyna",10, "Kredki","opis czynnosaci 1 ");
    Zajecie zajecie2 = new Zajecie("Justyna",20, "Papier", "opis czynnosci nr 2, opis czynnosci nr 2, opis czynnosci nr 2");

     String koment = kometarz1.getTresc();
     String zajec = zajecie1.getOpis();


   Zbiorka zbiorka1 = new Zbiorka("Justyna", "11-11-2022","przykladowy temat nr 2 ",
           "materiały zbiórkowe nr 2", koment, zajec,12);

        Zbiorka zbiorka2 = new Zbiorka("Karolina", "11-11-2022","przykladowy temat nr 2 ",
                "materiały zbiórkowe nr 2", koment, zajec,12);

    zbiorki.add(zbiorka1);
    zbiorki.add(zbiorka2);
    System.out.println(zbiorki);
return  zbiorki;
    }

}
