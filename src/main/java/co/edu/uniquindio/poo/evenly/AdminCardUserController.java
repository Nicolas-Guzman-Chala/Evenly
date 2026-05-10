package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class AdminCardUserController {

    @FXML
    private ChoiceBox<?> checkBoxUser;

    @FXML
    private Button editButton;

    @FXML
    private ImageView imgUser;

    @FXML
    private Button removeButton;

    @FXML
    private Label textKindOfCostumer;

    @FXML
    private Label textName;

    public void setUser(User user){

        textName.setText(user.getFullName());

        textKindOfCostumer.setText(
                user.getEmail()
        );

//        if(user.getImagePath() != null){
//
//            Image image = new Image(
//                    Objects.requireNonNull(getClass()
//                            .getResourceAsStream(user.getImagePath()))
//            );
//
//            imgUser.setImage(image);
//        }
    }

    @FXML
    void onEdit(ActionEvent event) {

    }

    @FXML
    void onRemove(ActionEvent event) {

    }

}

