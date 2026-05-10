package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.CategoriaEvento;
import co.edu.uniquindio.poo.evenly.classes.model.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.Event;
import co.edu.uniquindio.poo.evenly.classes.service.EventService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class EventController {

    private EventService eventService =
            new EventService();

    private List<Event> events =
            new ArrayList<>();

    @FXML
    private Slider MaxPriceRange;

    @FXML
    private Label labelPrice;


    @FXML
    private ChoiceBox<CategoriaEvento> categoryPicker;

    @FXML
    private ChoiceBox<Cities> cityPicker;

    @FXML
    private DatePicker datePicker;

    @FXML
    private FlowPane flowPane;

    @FXML
    private Label home;

    @FXML
    private Label merchandising;

    @FXML
    private ImageView user;

    @FXML
    void onApply(ActionEvent event) {

    }

    @FXML
    void onChangeEvents(MouseEvent event) {

    }

    @FXML
    void onChangeHome(MouseEvent event) {

    }

    @FXML
    void onChangeMerchandising(MouseEvent event) {

    }

    @FXML
    void onChangeProfile(MouseEvent event) {

    }



    @FXML
    public void initialize(){

        categoryPicker.getItems().addAll(CategoriaEvento.values());

        cityPicker.getItems().addAll(Cities.values());

        events = eventService.getEvent();

        renderEvents();

        MaxPriceRange.valueProperty().addListener((obs, oldVal, newVal) -> {

            labelPrice.setText("$" + newVal.intValue());

        });
    }

    public void renderEvents(){

        flowPane.getChildren().clear();

        for(Event event : events){

            try {

                FXMLLoader loader =
                        new FXMLLoader(
                                getClass().getResource(
                                        "/co/edu/uniquindio/poo/evenly/EventCard.fxml"
                                )
                        );

                Parent card = loader.load();

                EventCardController controller =
                        loader.getController();

                controller.setEvent(event);

                flowPane.getChildren().add(card);

            } catch (Exception e){

                e.printStackTrace();
            }
        }
    }
}

