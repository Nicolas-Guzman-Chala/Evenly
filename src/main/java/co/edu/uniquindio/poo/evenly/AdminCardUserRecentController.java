package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;
import co.edu.uniquindio.poo.evenly.classes.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class AdminCardUserRecentController {

    @FXML
    private ImageView imgUser;

    @FXML
    private Label textIncome;

    @FXML
    private Label textName;

    @FXML
    private Label textTickets;

    public void setUser(User user){

        textName.setText(user.getFullName());

        int totalTickets = 0;
        double totalIncome = 0;

        if(user.getPurchaseHistory() != null){

            for(Compra compra : user.getPurchaseHistory()){

                totalTickets += compra.getEntradas().size();

                totalIncome += compra.calcularTotal();
            }
        }

        textTickets.setText(totalTickets + " tickets");

        textIncome.setText("$ " + totalIncome);

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
}