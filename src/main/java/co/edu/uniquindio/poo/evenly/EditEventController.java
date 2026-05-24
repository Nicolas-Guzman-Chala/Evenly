package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.Evenly;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.CategoriaEvento;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEvento;
import co.edu.uniquindio.poo.evenly.classes.model.Event;
import co.edu.uniquindio.poo.evenly.classes.service.EventService;
import co.edu.uniquindio.poo.evenly.classes.navigation.SceneManager;
import co.edu.uniquindio.poo.evenly.classes.service.ImageService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;

public class EditEventController {

    private Event event;

    private final EventService eventService;

    private final SceneManager sceneManager;

    private final ImageService imageService;

    private String imagePath;

    public EditEventController() {

        Evenly evenly =
                Evenly.getInstance();

        this.eventService =
                evenly.getEventService();

        this.sceneManager =
                evenly.getSceneManager();

        this.imageService =
                evenly.getImageService();
    }

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
    private ChoiceBox<Cities> pickCity;

    @FXML
    private TextField textCapacity;

    @FXML
    private TextField textPrice;

    @FXML
    private TextField textVenue;

    @FXML
    public void initialize() {

        loadChoiceBoxes();
    }

    private void loadChoiceBoxes(){

        pickCategory
                .getItems()
                .addAll(
                        CategoriaEvento.values()
                );

        pickState
                .getItems()
                .addAll(
                        EstadoEvento.values()
                );

        pickCity
                .getItems()
                .addAll(
                        Cities.values()
                );
    }

    public void setEvent(Event event) {

        this.event = event;

        pickCategory.setValue(
                event.getCategory()
        );

        pickCategory.setDisable(true);

        loadEventData();
    }

    private void loadEventData(){

        inputNameEvent.setText(
                event.getName()
        );

        pickCity.setValue(
                event.getCity()
        );

        hourEvent.setText(
                event.getHour()
        );

        dateEventPicker.setValue(
                event.getDate()
        );

        pickCategory.setValue(
                event.getCategory()
        );

        pickState.setValue(
                event.getState()
        );

        imagePath =
                event.getImagePath();

        loadImage();
    }

    private void loadImage(){

        if(imagePath == null ||
                imagePath.isBlank()){

            return;
        }

        File file =
                new File(imagePath);

        if(!file.exists()){

            return;
        }

        imgEvent.setImage(

                new Image(

                        file.toURI()
                                .toString()
                )
        );
    }

    @FXML
    void uploadImage(ActionEvent event){

        String newImagePath =
                imageService.saveEventImage();

        if(newImagePath != null){

            imagePath = newImagePath;

            loadImage();
        }
    }

    @FXML
    void onEditEvent(ActionEvent actionEvent) {

        try {

            updateEventData();

            eventService.updateEvent(
                    event.getId(),
                    event
            );

            closeWindow();

            sceneManager.openAdminEvents();

            showAlert(
                    Alert.AlertType.INFORMATION,
                    "Evento actualizado correctamente"
            );

        } catch (Exception e){

            showAlert(
                    Alert.AlertType.ERROR,
                    e.getMessage()
            );
        }
    }

    private void updateEventData(){

        event.setName(
                inputNameEvent.getText()
        );

        event.setCity(
                pickCity.getValue()
        );

        event.setHour(
                hourEvent.getText()
        );

        event.setDate(
                dateEventPicker.getValue()
        );

        event.setState(
                pickState.getValue()
        );

        event.setImagePath(
                imagePath
        );
    }

    private void closeWindow() {

        Stage stage =

                (Stage) inputNameEvent
                        .getScene()
                        .getWindow();

        stage.close();
    }

    private void showAlert(
            Alert.AlertType type,
            String message
    ){

        Alert alert =
                new Alert(type);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }
}