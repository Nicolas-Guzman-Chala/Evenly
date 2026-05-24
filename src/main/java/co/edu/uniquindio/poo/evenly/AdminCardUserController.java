package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;
import co.edu.uniquindio.poo.evenly.classes.model.User;
import co.edu.uniquindio.poo.evenly.classes.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class AdminCardUserController {

    private User user;

    @FXML
    private ImageView imgUser;

    @FXML
    private Button removeButton;

    @FXML
    private Label textKindOfCostumer;

    @FXML
    private Label textName;

    @FXML
    private Label textTickets;

    @FXML
    private Label textIncome;


    public void setUser(User user){

        this.user = user;

        textName.setText(user.getFullName());

        textKindOfCostumer.setText(
                user.getEmail()
        );

        textTickets.setText(user.getPurchaseHistory().size() + "");

        double totalIncome = 0;

        if(user.getPurchaseHistory() != null){

            for(Compra compra : user.getPurchaseHistory()){

                totalIncome += compra.calcularTotal();
            }
        }

        textIncome.setText(
                "$ " + totalIncome
        );


        try {

            if(user.getImagePath() != null &&
                    !user.getImagePath().isEmpty()){

                Image image = new Image(
                        new File(user.getImagePath())
                                .toURI()
                                .toString()
                );

                imgUser.setImage(image);

            } else {

                Image defaultImage = new Image(
                        getClass().getResourceAsStream(
                                "/co/edu/uniquindio/poo/evenly/imgs/user-icon.png"
                        )
                );

                imgUser.setImage(defaultImage);
            }

        } catch (Exception e){

            e.printStackTrace();

            Image defaultImage = new Image(
                    getClass().getResourceAsStream(
                            "/co/edu/uniquindio/poo/evenly/imgs/user-icon.png"
                    )
            );

            imgUser.setImage(defaultImage);
        }
    }

    @FXML
    void onRemove(ActionEvent event) {
        try {

            UserService userService =
                    new UserService();

            userService.deleteUser(user.getIdUser());

            Alert alert = new Alert(
                    Alert.AlertType.INFORMATION
            );

            alert.setTitle("Usuario eliminado");

            alert.setHeaderText(null);

            alert.setContentText(
                    "El usuario fue eliminado correctamente"
            );

            alert.showAndWait();

            EvenlyApplication.changeScene(
                    "AdminUsers.fxml"
            );

        } catch (Exception e){

            e.printStackTrace();

            Alert alert = new Alert(
                    Alert.AlertType.ERROR
            );

            alert.setTitle("Error");

            alert.setHeaderText(null);

            alert.setContentText(
                    "No se pudo eliminar el usuario"
            );

            alert.showAndWait();
        }
    }

}

