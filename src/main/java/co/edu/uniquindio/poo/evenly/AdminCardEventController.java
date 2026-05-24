package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEvento;
import co.edu.uniquindio.poo.evenly.classes.model.Event;
import co.edu.uniquindio.poo.evenly.classes.service.EventService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;

public class AdminCardEventController {

    private final EventService eventService =
            new EventService();

    private Event event;

    @FXML
    private ChoiceBox<EstadoEvento> choiceBoxEvent;

    @FXML
    private Button editButton;

    @FXML
    private ImageView imgEvent;

    @FXML
    private Button removeButton;

    @FXML
    private Label textDate;

    @FXML
    private Label textHour;

    @FXML
    private Label textIncome;

    @FXML
    private Label textNameEvent;

    @FXML
    private Label textTicket;

    public void setEvent(Event event){

        this.event = event;

        choiceBoxEvent.getItems().addAll(
                EstadoEvento.values()
        );

        choiceBoxEvent.setValue(
                event.getState()
        );

        loadEventInfo();
    }

    @FXML
    void onChangeState(MouseEvent actionEvent){

        try {

            EstadoEvento nuevoEstado =
                    choiceBoxEvent.getValue();

            event.setState(
                    nuevoEstado
            );

            eventService.updateEvent(
                    event.getId(),
                    event
            );

        } catch (Exception e){

            e.printStackTrace();
        }
    }

    private void loadEventInfo(){

        if(event == null){

            return;
        }

        textNameEvent.setText(
                event.getName()
        );

        textIncome.setText(
                event.getCity().toString()
        );

        if(event.getDate() != null){

            textDate.setText(
                    event.getDate().toString()
            );
        }

        if(event.getHour() != null){

            textHour.setText(
                    event.getHour().toString()
            );
        }

        if(event.hasAvailableSeats()){

            textTicket.setText(
                    "Disponible"
            );

        } else {

            textTicket.setText(
                    "Agotado"
            );
        }

        loadEventImage();
    }

    private void loadEventImage(){

        if(event.getImagePath() == null ||
                event.getImagePath().isBlank()){

            return;
        }

        File file = new File(
                event.getImagePath()
        );

        if(!file.exists()){

            return;
        }

        imgEvent.setImage(
                new Image(
                        file.toURI().toString()
                )
        );
    }

    @FXML
    void onEdit(ActionEvent actionEvent) {

        openEditWindow();
    }

    private void openEditWindow(){

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/co/edu/uniquindio/poo/evenly/EditCardEvent.fxml"
                            )
                    );

            Parent root = loader.load();

            EditEventController controller =
                    loader.getController();

            controller.setEvent(event);

            Stage stage = new Stage();

            stage.setScene(
                    new Scene(root)
            );

            stage.showAndWait();

        } catch (Exception exception){

            exception.printStackTrace();
        }
    }

    @FXML
    void onRemove(ActionEvent actionEvent) {

        deleteEvent();
    }

    private void deleteEvent(){

        if(event == null){

            return;
        }

        try {

            eventService.deleteEvent(
                    event.getId()
            );

            EvenlyApplication.changeScene(
                    "AdminEvents.fxml"
            );

        } catch (Exception exception){

            exception.printStackTrace();
        }
    }
}