package projektindywidualny.projektindywidualny.Viev;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.data.value.ValueChangeMode;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.EnableVaadin;
import com.vaadin.flow.theme.lumo.LumoUtility;
import projektindywidualny.projektindywidualny.Service.ZbiorkaService;
import projektindywidualny.projektindywidualny.ksiazka.Domain.Zbiorka;
@Route
@EnableVaadin
public class MainViev extends VerticalLayout {


    private ZbiorkaService zbiorkaService = ZbiorkaService.getInstance();
    private Grid <Zbiorka> grid = new Grid<>(Zbiorka.class);
    private TextField filtrData = new TextField();
    private TextField zajęcia = new TextField();



    public MainViev() {




        grid.setColumns("autor", "data", "temat","komentarze","czasZbiorki", "zatwierdzona");
        //  grid.setColumns("autor", "data", "temat", "zajecia ", "Czas",  "zatwierdzona", "czas zbiorki"  );


        grid.setSelectionMode (Grid.SelectionMode.SINGLE);
        filtrData.addValueChangeListener(e -> update());
        filtrData.setPlaceholder("Filtruj po dacie");
        filtrData.setClearButtonVisible(true);
        filtrData.addValueChangeListener(e -> update());
        filtrData.setValueChangeMode(ValueChangeMode.ON_CHANGE);
        add(filtrData, grid);
        add(grid);
        setSizeFull();

        refresh();
        update();

    }



    private void grid(TextField filtrData) { }

    public void refresh() {
        grid.setItems(zbiorkaService.getZbiorki());
        System.out.println(zbiorkaService.getZbiorki());
    }
    public void update(){
        grid.setItems(zbiorkaService.findByDate(filtrData.getValue()));
        System.out.println(zbiorkaService.getZbiorki());
    }
}
