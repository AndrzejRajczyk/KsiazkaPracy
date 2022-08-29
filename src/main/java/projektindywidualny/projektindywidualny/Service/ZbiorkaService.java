package projektindywidualny.projektindywidualny.Service;


import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import lombok.Getter;
import lombok.Setter;
import projektindywidualny.projektindywidualny.Domain.Komentarze;
import projektindywidualny.projektindywidualny.Domain.Zajecie;
import projektindywidualny.projektindywidualny.Domain.Zbiorka;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;




@Route
@Setter
@Getter
public class ZbiorkaService {
    private Set<Zbiorka> zbiorki;
    private static ZbiorkaService zbiorkaService;
    private TextField textField;
    private Binder<Zbiorka> binder = new Binder(Zbiorka.class);

    public ZbiorkaService() {
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
    public void   removeZbiorka(Zbiorka zbiorka){
        zbiorki.remove(zbiorka);

    }
    public void save(Zbiorka zbiorka){
        this.zbiorki.add(zbiorka);
    }
    public void delete(Zbiorka zbiorka){
        this.zbiorki.remove(zbiorka);
    }
    public void setZbiorka(Zbiorka zbiorka){
        binder.setBean(zbiorka);
       // if (zbiorka == null) {
       //     setVisible();

      //  } else {
         //   setVisible();
            //autor.focus();


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
