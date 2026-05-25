package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.User;
import co.edu.uniquindio.poo.evenly.classes.model.UserSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;

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
    public void initialize() {
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
        EvenlyApplication.changeScene("Merchandising.fxml");
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

