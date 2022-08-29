package projektindywidualny.projektindywidualny.Domain;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import projektindywidualny.projektindywidualny.Service.ZbiorkaService;
import projektindywidualny.projektindywidualny.Viev.MainViev;

public class ZbiorkaForm extends FormLayout {
    ZbiorkaService zbiorkaService = new ZbiorkaService();
    private TextField autorPole = new TextField("autor");
    private TextField dataPole = new TextField("data");
    private TextField tematPole = new TextField("temat");
    //private TextField  materialyPole= new TextField ("materiały");
    private TextArea komentarzePole = new TextArea("komentarze");
    // private TextField  zajeciaPole= new TextField ("zajecia");
    private TextField czasZbiorkiPole = new TextField("czas zbiórki");
    private TextField typePole = new TextField("zatwierdzona");
    private Button save = new Button("Zapisz");
    private Button delete = new Button("Usuń");
    private MainViev mainViev;
    private Binder<Zbiorka> binder = new Binder(Zbiorka.class);

    public ZbiorkaForm(MainViev mainViev) {

        //type.setItems(Zbiorka.values());
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(autorPole, dataPole, tematPole, czasZbiorkiPole);
        this.mainViev = mainViev;
        save.addClickListener(event -> save());
        delete.addClickListener(event -> delete());
        add(save, delete);

    }

    private void save() {
        Zbiorka zbiorka = binder.getBean();
        zbiorkaService.addZbiorki(zbiorka);
        mainViev.refresh();

        zbiorkaService.setZbiorka(null);
        zbiorkaService.setZbiorka(null);

    }

    private void delete() {
        Zbiorka zbiorka = binder.getBean();
        zbiorkaService.removeZbiorka(zbiorka);
        mainViev.refresh();
        zbiorkaService.setZbiorka(null);
    }
}

