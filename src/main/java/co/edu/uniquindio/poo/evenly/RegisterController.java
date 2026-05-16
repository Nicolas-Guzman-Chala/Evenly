package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.User;
import co.edu.uniquindio.poo.evenly.classes.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RegisterController {

    @FXML
    private TextField inputEmail;

    @FXML
    private TextField inputFullName;

    @FXML
    private PasswordField inputPassword;

    @FXML
    private TextField inputPhoneNumber;

    @FXML
    private CheckBox onAcept;

    private UserService userService =
            new UserService();

    @FXML
    void onChangeHome(MouseEvent event){
        EvenlyApplication.changeScene("Home.fxml");
    }

    @FXML
    void onChangeLogin(MouseEvent event){
        EvenlyApplication.changeScene("Login.fxml");
    }

    @FXML
    void onCreateAccount(ActionEvent event) {

        String fullName =
                inputFullName.getText();

        String email =
                inputEmail.getText();

        String password =
                inputPassword.getText();

        String phone =
                inputPhoneNumber.getText();

        if(fullName.isEmpty() ||
                email.isEmpty() ||
                password.isEmpty() ||
                phone.isEmpty()) {

            System.out.println(
                    "Complete all fields"
            );

            return;
        }

        if(!onAcept.isSelected()) {

            System.out.println(
                    "Accept terms and conditions"
            );

            return;
        }

        int id =
                userService.generateId();

        User user =
                new User(
                        id,
                        fullName,
                        email,
                        password,
                        phone,
                        ""
                );

        userService.createUser(user);

        System.out.println(
                "User registered successfully"
        );

        EvenlyApplication.changeScene(
                "Login.fxml"
        );
    }
}