package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.CategoriaEvento;
import co.edu.uniquindio.poo.evenly.classes.model.EstadoEvento;
import co.edu.uniquindio.poo.evenly.classes.model.Event;
import co.edu.uniquindio.poo.evenly.classes.service.EventService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;

public class EditEventController {

    private Event event;

    private EventService eventService =
            new EventService();

    @FXML
    private DatePicker dateEventPicker;

    @FXML
    private TextField hourEvent;

    @FXML
    private ImageView imgEvent;

    @FXML
    private TextField inputNameEvent;

    @FXML
    private ChoiceBox<CategoriaEvento> pickCategory;

    @FXML
    private ChoiceBox<EstadoEvento> pickState;

    @FXML
    private TextField textCapacity;

    @FXML
    private TextField textCity;

    @FXML
    private TextField textPrice;

    @FXML
    private TextField textVenue;

    @FXML
    private TextField textZone;

    @FXML
    public void initialize() {

        pickCategory.getItems()
                .addAll(CategoriaEvento.values());

        pickState.getItems()
                .addAll(EstadoEvento.values());
    }

    public void setEvent(Event event) {

        this.event = event;

        inputNameEvent.setText(event.getName());

        textCity.setText(event.getCity());

//        textVenue.setText(event.getVenue());
//
//        textZone.setText(event.getZone());

        textCapacity.setText(
                String.valueOf(event.getCapacity())
        );

        textPrice.setText(
                String.valueOf(event.getPrice())
        );

        hourEvent.setText(event.getHour());

        dateEventPicker.setValue(event.getDate());

        pickCategory.setValue(event.getCategory());

        pickState.setValue(event.getState());

        if (event.getImagePath() != null &&
                !event.getImagePath().isEmpty()) {

            imgEvent.setImage(
                    new Image(
                            new File(event.getImagePath())
                                    .toURI()
                                    .toString()
                    )
            );
        }
    }

    @FXML
    void onEditEvent(ActionEvent e) {

        try {

            event.setName(
                    inputNameEvent.getText()
            );

            event.setCity(
                    textCity.getText()
            );

//            event.setVenue(
//                    textVenue.getText()
//            );
//
//            event.setZone(
//                    textZone.getText()
//            );

            event.setCapacity(
                    Integer.parseInt(
                            textCapacity.getText()
                    )
            );

            event.setPrice(
                    Double.parseDouble(
                            textPrice.getText()
                    )
            );

            event.setHour(
                    hourEvent.getText()
            );

            event.setDate(
                    dateEventPicker.getValue()
            );

            event.setCategory(
                    pickCategory.getValue()
            );

            event.setState(
                    pickState.getValue()
            );

            eventService.updateEvent(event.getId(),event);

            closeWindow();

            EvenlyApplication.changeScene("AdminEvents.fxml");

            System.out.println(
                    "Evento actualizado correctamente"
            );

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    public void closeWindow() {

        Stage stage = (Stage)
                inputNameEvent
                        .getScene()
                        .getWindow();

        stage.close();
    }
}