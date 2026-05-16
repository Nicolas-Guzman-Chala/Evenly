package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.UserSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class HomeController {

    @FXML
    private Button EventsButton;

    @FXML
    private Label events;

    @FXML
    private Label home;

    @FXML
    private Label merchandising;

    @FXML
    private ImageView user;

    @FXML
    void onChangeEvents(ActionEvent event) {
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

}

