package co.edu.uniquindio.poo.evenly;

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
import javafx.stage.Stage;

import java.io.File;

public class AdminCardEventController {

    private Event event;

    @FXML
    private ChoiceBox<?> choiceBoxEvent;

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

        textNameEvent.setText(event.getName());

        if(event.getDate() != null){
            textDate.setText(event.getDate().toString());
        }

        imgEvent.setImage(
                new Image(
                        new File(event.getImagePath())
                                .toURI()
                                .toString()
                )
        );

        textIncome.setText(String.valueOf(event.getCity()));

        textTicket.setText(String.valueOf(event.getHour()));

    }

    @FXML
    void onEdit(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/co/edu/uniquindio/poo/evenly/EditCardEvent.fxml"
                    )
            );

            Parent root = loader.load();

            EditEventController controller =
                    loader.getController();

            controller.setEvent(this.event);

            Stage stage = new Stage();

            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.showAndWait();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    @FXML
    void onRemove(ActionEvent hola) {

        try {

            EventService eventService =
                    new EventService();

            eventService.deleteEvent(
                    event.getId()
            );

            EvenlyApplication.changeScene("AdminEvents.fxml");

            System.out.println(
                    "Evento eliminado"
            );

        } catch (Exception ex){

            ex.printStackTrace();
        }
    }

}

