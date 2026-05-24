package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;
import co.edu.uniquindio.poo.evenly.classes.model.Purchase;
import co.edu.uniquindio.poo.evenly.classes.model.User;
import co.edu.uniquindio.poo.evenly.classes.navigation.SceneManager;
import co.edu.uniquindio.poo.evenly.classes.service.ImageService;
import co.edu.uniquindio.poo.evenly.classes.service.UserService;
import co.edu.uniquindio.poo.evenly.classes.model.UserSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.File;

public class UserInformationController {

    private final SceneManager sceneManager =
            new SceneManager();

    private final UserService userService =
            new UserService();

    private final ImageService imageService =
            new ImageService();

    private User currentUser;

    @FXML
    private Label events;

    @FXML
    private Label home;

    @FXML
    private ImageView imgPhotoProfile;

    @FXML
    private ImageView imgUser;

    @FXML
    private TextField inputEmail;

    @FXML
    private TextField inputFullName;

    @FXML
    private PasswordField inputPassword;

    @FXML
    private TextField inputPhone;

    @FXML
    private Label merchandising;

    @FXML
    private Label textFullName;

    @FXML
    private VBox vBoxContainer;

    @FXML
    public void initialize() {

        currentUser =
                UserSession.getCurrentUser();

        loadUserInfo();

        loadHistory();
    }

    private void loadUserInfo() {

        if(currentUser == null){
            return;
        }

        inputFullName.setText(
                currentUser.getFullName()
        );

        inputEmail.setText(
                currentUser.getEmail()
        );

        inputPhone.setText(
                currentUser.getPhone()
        );

        inputPassword.setText(
                currentUser.getPassword()
        );

        textFullName.setText(
                currentUser.getFullName()
        );

        loadImages();
    }

    private void loadImages() {

        if(currentUser.getImagePath() != null &&
                !currentUser.getImagePath().isEmpty()) {

            File file =
                    new File(currentUser.getImagePath());

            Image image =
                    new Image(file.toURI().toString());

            imgPhotoProfile.setImage(image);

            imgUser.setImage(image);
        }
    }

    private void loadHistory() {

        try {

            vBoxContainer.getChildren().clear();

            for(Compra compra :
                    currentUser.getPurchaseHistory()) {

                FXMLLoader loader =
                        new FXMLLoader(
                                getClass().getResource(
                                        "/co/edu/uniquindio/poo/evenly/HistoryUserCard.fxml"
                                )
                        );

                Parent root =
                        loader.load();

                HistoryUserCardController controller =
                        loader.getController();

                controller.setData(compra);

                vBoxContainer
                        .getChildren()
                        .add(root);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @FXML
    void changeInfo(ActionEvent event) {

        currentUser.setFullName(
                inputFullName.getText()
        );

        currentUser.setEmail(
                inputEmail.getText()
        );

        currentUser.setPhone(
                inputPhone.getText()
        );

        currentUser.setPassword(
                inputPassword.getText()
        );

        userService.updateUser(
                currentUser.getIdUser(),
                currentUser
        );

        textFullName.setText(
                currentUser.getFullName()
        );
    }

    @FXML
    void changePassword(ActionEvent event) {

        currentUser.setPassword(
                inputPassword.getText()
        );

        userService.updateUser(
                currentUser.getIdUser(),
                currentUser
        );
    }

    @FXML
    void changePhoto(ActionEvent event) {

        String path =
                imageService.saveEventImage();

        if(path != null) {

            currentUser.setImagePath(path);

            userService.updateUser(
                    currentUser.getIdUser(),
                    currentUser
            );

            loadImages();
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

    }

    @FXML
    void onChangeProfile(MouseEvent event) {

        sceneManager.openProfile();
    }
}