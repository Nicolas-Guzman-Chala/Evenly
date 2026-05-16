package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.CategoriaEvento;
import co.edu.uniquindio.poo.evenly.classes.model.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.Event;
import co.edu.uniquindio.poo.evenly.classes.model.UserSession;
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

import java.util.ArrayList;
import java.util.List;

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
    void onApply(ActionEvent e) {
        CategoriaEvento category =
                categoryPicker.getValue();

        Cities city =
                cityPicker.getValue();

        double priceMax =
                MaxPriceRange.getValue();

        List<Event> eventsFiltered =
                new ArrayList<>();

        for(Event event : eventService.getEvent()) {

            boolean categoryMatch =
                    category == CategoriaEvento.TODOS ||
                            event.getCategory().equals(category);

            boolean cityMatch =
                    city == Cities.TODAS ||
                            event.getCity().equals(city);

            boolean priceMatch =
                    event.getPrice() <= priceMax;

            if(categoryMatch &&
                    cityMatch &&
                    priceMatch) {

                eventsFiltered.add(event);
            }
        }

        renderEvents(eventsFiltered);
    }

    @FXML
    void onChangeEvents(MouseEvent event) {
        EvenlyApplication.changeScene("Events.fxml");
    }

    @FXML
    void onChangeHome(MouseEvent event) {
        EvenlyApplication.changeScene("Home.fxml");
    }

    @FXML
    void onChangeMerchandising(MouseEvent event) {

    }
    @FXML
    void onChangeProfile(MouseEvent event) {
        if(UserSession.getCurrentUser() == null) {

            EvenlyApplication.changeScene(
                    "Register.fxml"
            );

        } else {

            EvenlyApplication.changeScene(
                    "Profile.fxml"
            );
        }
    }



    @FXML
    public void initialize(){

        categoryPicker.getItems().addAll(CategoriaEvento.values());

        cityPicker.getItems().addAll(Cities.values());

        events = eventService.getEvent();

        categoryPicker.setValue(CategoriaEvento.TODOS);
        cityPicker.setValue(Cities.TODAS);

        renderEvents(events);

        MaxPriceRange.setValue(500000);

        MaxPriceRange.valueProperty().addListener((obs, oldVal, newVal) -> {

            labelPrice.setText("$" + newVal.intValue());

        });
    }

    public void renderEvents(List<Event> events){

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

