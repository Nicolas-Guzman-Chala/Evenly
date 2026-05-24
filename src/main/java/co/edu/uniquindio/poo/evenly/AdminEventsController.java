package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.TipoZona;
import co.edu.uniquindio.poo.evenly.classes.model.Evenly;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.CategoriaEvento;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEvento;
import co.edu.uniquindio.poo.evenly.classes.model.Event;
import co.edu.uniquindio.poo.evenly.classes.model.Recinto;
import co.edu.uniquindio.poo.evenly.classes.model.EventFactoryDTO.CreateEventDTO;
import co.edu.uniquindio.poo.evenly.classes.model.Zona;
import co.edu.uniquindio.poo.evenly.classes.navigation.SceneManager;
import co.edu.uniquindio.poo.evenly.classes.service.EventService;
import co.edu.uniquindio.poo.evenly.classes.service.ImageService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class AdminEventsController {

    private final EventService eventService;

    private final SceneManager sceneManager;

    private final ImageService imageService;

    private List<Event> events = new ArrayList<>();

    private String imagePath;

    public AdminEventsController(){

        Evenly evenly = Evenly.getInstance();

        this.eventService = evenly.getEventService();

        this.sceneManager = evenly.getSceneManager();

        this.imageService = evenly.getImageService();
    }

    @FXML
    private ChoiceBox<CategoriaEvento> pickCategory;

    @FXML
    private ChoiceBox<EstadoEvento> pickState;

    @FXML
    private ChoiceBox<Cities> pickCity;

    @FXML
    private DatePicker dateEventPicker;

    @FXML
    private TextField hourEvent;

    @FXML
    private TextField inputNameEvent;

    @FXML
    private TextField textVenue;

    @FXML
    private TextField textCapacity;

    @FXML
    private TextField textPrice;

    @FXML
    private VBox vBoxContainer;

    @FXML
    private ImageView imgUser;

    @FXML
    public void initialize(){

        loadChoiceBoxes();

        refreshEvents();
    }

    private void loadChoiceBoxes(){

        pickCategory.getItems().addAll(
                CategoriaEvento.values()
        );

        pickState.getItems().addAll(
                EstadoEvento.values()
        );

        pickCity.getItems().addAll(
                Cities.values()
        );
    }

    @FXML
    void uploadImage(){

        imagePath = imageService.saveEventImage();
    }

    @FXML
    void onCreateEvent(ActionEvent event){

        try {

            CreateEventDTO dto = buildDTO();

            eventService.createEvent(dto);

            refreshEvents();

            clearFields();

            showAlert(
                    Alert.AlertType.INFORMATION,
                    "Evento creado correctamente"
            );

        } catch (Exception e){

            e.printStackTrace();

            showAlert(
                    Alert.AlertType.ERROR,
                    e.getMessage()
            );
        }
    }

    private CreateEventDTO buildDTO(){

        if(inputNameEvent.getText().isEmpty()){
            throw new RuntimeException(
                    "Ingrese el nombre del evento"
            );
        }

        if(pickCity.getValue() == null){
            throw new RuntimeException(
                    "Seleccione una ciudad"
            );
        }

        if(dateEventPicker.getValue() == null){
            throw new RuntimeException(
                    "Seleccione una fecha"
            );
        }

        if(hourEvent.getText().isEmpty()){
            throw new RuntimeException(
                    "Ingrese una hora"
            );
        }

        if(textVenue.getText().isEmpty()){
            throw new RuntimeException(
                    "Ingrese un recinto"
            );
        }

        if(textCapacity.getText().isEmpty()){
            throw new RuntimeException(
                    "Ingrese una capacidad"
            );
        }

        if(textPrice.getText().isEmpty()){
            throw new RuntimeException(
                    "Ingrese un precio"
            );
        }

            Recinto recinto = new Recinto(
                    java.util.UUID.randomUUID().toString(),
                    textVenue.getText(),
                    textVenue.getText(),
                    pickCity.getValue()
            );

            Zona vip = new Zona(
                    java.util.UUID.randomUUID().toString(),
                    "VIP",
                    50,
                    Double.parseDouble(textPrice.getText()) * 2,
                    TipoZona.VIP
            );

            Zona general = new Zona(
                    java.util.UUID.randomUUID().toString(),
                    "GENERAL",
                    100,
                    Double.parseDouble(textPrice.getText()),
                    TipoZona.GENERAL
            );

        Zona preferencial = new Zona(
                java.util.UUID.randomUUID().toString(),
                "GENERAL",
                100,
                Double.parseDouble(textPrice.getText()),
                TipoZona.PREFERENCIAL
        );

        Zona economy = new Zona(
                java.util.UUID.randomUUID().toString(),
                "GENERAL",
                100,
                Double.parseDouble(textPrice.getText()),
                TipoZona.ECONOMY
        );

            recinto.agregarZona(vip);
            recinto.agregarZona(general);
            recinto.agregarZona(preferencial);
            recinto.agregarZona(economy);

            return new CreateEventDTO(

                    inputNameEvent.getText(),

                    pickCity.getValue(),

                    dateEventPicker.getValue(),

                    hourEvent.getText(),

                    pickCategory.getValue(),

                    pickState.getValue(),

                    imagePath,

                    recinto,

                    Double.parseDouble(textPrice.getText())
            );
    }

    private void refreshEvents(){

        events = eventService.getEvents();

        if(events == null){

            events = new ArrayList<>();
        }

        renderEvents();
    }

    private void renderEvents(){

        vBoxContainer
                .getChildren()
                .clear();

        for(Event event : events){

            try {

                FXMLLoader loader =
                        new FXMLLoader(
                                getClass().getResource(
                                        "/co/edu/uniquindio/poo/evenly/AdminCardEvent.fxml"
                                )
                        );

                Parent card = loader.load();

                AdminCardEventController controller =
                        loader.getController();

                controller.setEvent(event);

                vBoxContainer
                        .getChildren()
                        .add(card);

            } catch (Exception e){

                e.printStackTrace();
            }
        }
    }

    @FXML
    void onChangeDashboard(MouseEvent event){

        sceneManager.openAdminDashboard();
    }

    @FXML
    void onChangeEvents(MouseEvent event){

        sceneManager.openAdminEvents();
    }

    @FXML
    void onChangeReports(MouseEvent event){

    }

    @FXML
    void onChangeUsers(MouseEvent event){

        sceneManager.openAdminUsers();
    }

    @FXML
    void onChangelogout(MouseEvent event){

    }

    private void clearFields(){

        inputNameEvent.clear();

        textVenue.clear();

        textCapacity.clear();

        textPrice.clear();

        hourEvent.clear();

        pickCategory.setValue(null);

        pickState.setValue(null);

        pickCity.setValue(null);

        dateEventPicker.setValue(null);

        imagePath = null;
    }

    private void showAlert(
            Alert.AlertType type,
            String message
    ){

        Alert alert = new Alert(type);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }
}