package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.User;
import co.edu.uniquindio.poo.evenly.classes.model.UserSession;
import co.edu.uniquindio.poo.evenly.classes.navigation.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class MerchandisingController {

    @FXML
    private Label events;

    @FXML
    private Label home;

    @FXML
    private ImageView imgUser;

    @FXML
    private Label merchandising;

    private SceneManager sceneManager = new SceneManager();
    @FXML
    public void initialize() {
        loadUserImage();
    }
    private void loadUserImage() {

        User user = UserSession.getCurrentUser();

        if (user == null || user.getImagePath() == null || user.getImagePath().isBlank()) {
            return;
        }

        File file = new File(user.getImagePath());

        if (!file.exists()) {
            return;
        }

        imgUser.setImage(new Image(file.toURI().toString()));
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
        EvenlyApplication.changeScene("Merchandising.fxml");
    }

    @FXML
    void onChangeProfile(MouseEvent event) {
        sceneManager.openProfile();
    }

}
