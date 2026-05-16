package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.User;
import co.edu.uniquindio.poo.evenly.classes.model.UserSession;
import co.edu.uniquindio.poo.evenly.classes.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private TextField inputEmail;

    @FXML
    private PasswordField inputPassword;

    private UserService userService = new UserService();

    @FXML
    void onChangeHome(MouseEvent event) {
        EvenlyApplication.changeScene("Home.fxml");
    }

    @FXML
    void onChangeRegister(ActionEvent event) {
        EvenlyApplication.changeScene("Register.fxml");
    }

    @FXML
    void onLogin(ActionEvent event) {
        String email =
                inputEmail.getText();

        String password =
                inputPassword.getText();

        if (email.isEmpty() ||
                password.isEmpty()) {

            System.out.println(
                    "Complete all fields"
            );

            return;
        }

        User user =
                userService.login(
                        email,
                        password
                );

        if (user == null) {

            System.out.println(
                    "Incorrect credentials"
            );

            return;
        }

        UserSession.setCurrentUser(
                user
        );

        System.out.println(
                "Successful login"
        );

        EvenlyApplication.changeScene(
                "Home.fxml"
        );
    }
}