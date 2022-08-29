package projektindywidualny.projektindywidualny.Viev;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.EnableVaadin;
import projektindywidualny.projektindywidualny.Service.ZbiorkaService;
import projektindywidualny.projektindywidualny.Domain.Zbiorka;
import projektindywidualny.projektindywidualny.Domain.ZbiorkaForm;

@Route
@EnableVaadin
public class MainViev extends VerticalLayout {


    private ZbiorkaService zbiorkaService = ZbiorkaService.getInstance();
    private Grid<Zbiorka> grid = new Grid<>(Zbiorka.class);
    private TextField filtrAutor = new TextField();

    private ZbiorkaForm form = new ZbiorkaForm(this);
    Checkbox checkbox = new Checkbox();
    public MainViev() {

         add(grid);
         grid.addColumn(zbiorka->{
             Checkbox checkbox1 = new Checkbox();
             checkbox1.setValue(false);
             return checkbox1;
         }).setHeader("wybierz").setKey("");


        grid.setColumns("autor", "data", "temat", "komentarze", "czasZbiorki", "zatwierdzona");
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        filtrAutor.addValueChangeListener(e -> update());
        filtrAutor.setPlaceholder("Filtruj po autorze");
        filtrAutor.setClearButtonVisible(true);
        filtrAutor.addValueChangeListener(e -> update());
        filtrAutor.setValueChangeMode(ValueChangeMode.EAGER);
        add(filtrAutor, grid);
        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        add(mainContent);
        mainContent.setSizeFull();
        setSizeFull();

        refresh();
        update();

    }


    private void grid(TextField filtrData) {
    }

    public void refresh() {
        grid.setItems(zbiorkaService.getZbiorki());
        System.out.println(zbiorkaService.getZbiorki());
    }

    public void update() {
        grid.setItems(zbiorkaService.findByAutor(filtrAutor.getValue()));
        System.out.println(zbiorkaService.getZbiorki());
    }

}
