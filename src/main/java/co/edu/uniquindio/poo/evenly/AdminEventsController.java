package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.EstadoEvento;
import co.edu.uniquindio.poo.evenly.classes.model.Event;
import co.edu.uniquindio.poo.evenly.classes.service.EventService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AdminEventsController {

    private EventService eventService =
            new EventService();

    private List<Event> events = new ArrayList<>();

    private String imagePath;

    @FXML
    private ChoiceBox<CategoriaEvento> pickCategory;

    @FXML
    private ChoiceBox<EstadoEvento> pickState;

    @FXML
    private DatePicker dateEventPicker;

    @FXML
    private TextField hourEvent;

    @FXML
    private ImageView imgUser;

    @FXML
    private TextField inputNameEvent;

    @FXML
    private TextField textCapacity;

    @FXML
    private ChoiceBox<Cities> pickCity;

    @FXML
    private Label textName;

    @FXML
    private TextField textPrice;

    @FXML
    private TextField textVenue;

    @FXML
    private VBox vBoxContainer;

    @FXML
    public void initialize(){

        pickCategory.getItems().addAll(CategoriaEvento.values());

        pickState.getItems().addAll(EstadoEvento.values());

        pickCity.getItems().addAll(Cities.values());
        events = eventService.getEvent();

        renderEvents();
    }

    @FXML
    void uploadImage() {

        FileChooser fileChooser = new FileChooser();

        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "Imágenes",
                        "*.png",
                        "*.jpg",
                        "*.jpeg"
                )
        );

        File file = fileChooser.showOpenDialog(null);

        if (file != null) {

            try {

                File folder = new File("storage/images");

                if (!folder.exists()) {
                    folder.mkdirs();
                }

                String fileName =
                        System.currentTimeMillis()
                                + "_"
                                + file.getName();

                File destination = new File(
                        folder,
                        fileName
                );

                java.nio.file.Files.copy(
                        file.toPath(),
                        destination.toPath(),
                        java.nio.file.StandardCopyOption.REPLACE_EXISTING
                );

                imagePath = destination
                        .getAbsolutePath()
                        .replace("\\", "/");

                System.out.println("Imagen guardada: " + imagePath);

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public void renderEvents(){

        vBoxContainer.getChildren().clear();

        for(Event event : events){

            try {

                FXMLLoader loader = new FXMLLoader(
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
    void onChangeDashboard(MouseEvent event) {
        EvenlyApplication.changeScene("AdminDashboard.fxml");
    }

    @FXML
    void onChangeEvents(MouseEvent event) {
        EvenlyApplication.changeScene("AdminSales.fxml");
    }

    @FXML
    void onChangeReports(MouseEvent event) {

    }

    @FXML
    void onChangeUsers(MouseEvent event) {
        EvenlyApplication.changeScene("AdminUsers.fxml");
    }

    @FXML
    void onChangelogout(MouseEvent event) {

    }

    @FXML
    void onCreateEvent(ActionEvent event) {

        try {

            int id = events.size() + 1;

            String name = inputNameEvent.getText();

            Cities city = pickCity.getValue();

            String venue = textVenue.getText();


            int capacity = Integer.parseInt(textCapacity.getText());

            double price = Double.parseDouble(textPrice.getText());

            String hour = hourEvent.getText();

            CategoriaEvento categoria =
                    pickCategory.getValue();

            EstadoEvento estado =
                    pickState.getValue();

          //aqui se tendra que usar algo para crear eventos con el tipo, algun choice box o algo por el estilo
            Event newEvent = new Event(
                    id,
                    name,
                    city,
                    venue,
                    capacity,
                    price,
                    dateEventPicker.getValue(),
                    hour,
                    categoria,
                    estado,
                    "",
                    imagePath
            );

            eventService.createEvent(newEvent);

            events = eventService.getEvent();

            renderEvents();

            clearFields();

            System.out.println("Evento creado correctamente");

        } catch (Exception e){

            System.out.println("Error al crear evento");

            e.printStackTrace();
        }
    }

    public void clearFields(){

        inputNameEvent.clear();
        pickCity.setValue(null);
        textVenue.clear();
        textCapacity.clear();
        textPrice.clear();
        hourEvent.clear();
        dateEventPicker.setValue(null);
        pickCategory.setValue(null);
        pickState.setValue(null);
    }
}
