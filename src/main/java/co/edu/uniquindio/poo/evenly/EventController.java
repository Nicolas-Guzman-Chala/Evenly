package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.Evenly;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.CategoriaEvento;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.Event;
import co.edu.uniquindio.poo.evenly.classes.model.User;
import co.edu.uniquindio.poo.evenly.classes.model.UserSession;
import co.edu.uniquindio.poo.evenly.classes.service.EventService;
import co.edu.uniquindio.poo.evenly.classes.navigation.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.io.File;
import java.util.List;

public class EventController {

    private final EventService eventService;

    private final SceneManager sceneManager;

    public EventController() {

        Evenly evenly =
                Evenly.getInstance();

        this.eventService =
                evenly.getEventService();

        this.sceneManager =
                evenly.getSceneManager();
    }

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
    public void initialize(){

        loadFilters();

        configurePriceSlider();

        renderEvents(
                eventService.getEvents()
        );
        loadUserImage();
    }
    private void loadUserImage() {

        User userr = UserSession.getCurrentUser();

        if (userr == null || userr.getImagePath() == null || userr.getImagePath().isBlank()) {
            return;
        }

        File file = new File(userr.getImagePath());

        if (!file.exists()) {
            return;
        }

        user.setImage(new Image(file.toURI().toString()));
    }
    private void loadFilters(){

        categoryPicker
                .getItems()
                .addAll(
                        CategoriaEvento.values()
                );

        cityPicker
                .getItems()
                .addAll(
                        Cities.values()
                );

        categoryPicker.setValue(
                CategoriaEvento.TODOS
        );

        cityPicker.setValue(
                Cities.TODAS
        );
    }

    private void configurePriceSlider(){

        MaxPriceRange.setValue(
                500000
        );

        labelPrice.setText(
                "$500000"
        );

        MaxPriceRange
                .valueProperty()
                .addListener((obs, oldVal, newVal) -> {

                    labelPrice.setText(
                            "$" + newVal.intValue()
                    );
                });
    }

    @FXML
    void onApply(ActionEvent event) {

        List<Event> filteredEvents =
                eventService.filterEvents(

                        categoryPicker.getValue(),

                        cityPicker.getValue(),

                        MaxPriceRange.getValue(),

                        datePicker.getValue()
                );

        renderEvents(filteredEvents);
    }

    private void renderEvents(
            List<Event> events
    ){

        flowPane.getChildren().clear();

        for(Event event : events){

            try {

                FXMLLoader loader =
                        new FXMLLoader(
                                getClass().getResource(
                                        "/co/edu/uniquindio/poo/evenly/EventCard.fxml"
                                )
                        );

                Parent card =
                        loader.load();

                EventCardController controller =
                        loader.getController();

                controller.setEvent(event);

                flowPane
                        .getChildren()
                        .add(card);

            } catch (Exception e){

                e.printStackTrace();
            }
        }
    }

    @FXML
    void onChangeEvents(MouseEvent event) {

        sceneManager.openEvents();
    }

    @FXML
    void onChangeHome(MouseEvent event) {

        sceneManager.openHome();
    }

    @FXML
    void onChangeMerchandising(MouseEvent event) {
        EvenlyApplication.changeScene("Merchandising.fxml");
    }

    @FXML
    void onChangeProfile(MouseEvent event) {

        if(UserSession.getCurrentUser() == null){

            sceneManager.openRegister();

        } else {

            sceneManager.openProfile();
        }
    }
}