package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.User;
import co.edu.uniquindio.poo.evenly.classes.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class AdminUsersController {

    private UserService userService =
            new UserService();

    private List<User> users = new ArrayList<>();

    @FXML
    private ImageView imgUser;

    @FXML
    private Label textName;

    @FXML
    private Label textValue1;

    @FXML
    private Label textValue2;

    @FXML
    private Label textValue3;

    @FXML
    private VBox vBoxContainerRecent;

    @FXML
    private VBox vboxContainer;

    @FXML
    public void initialize(){
        users = userService.getUsers();

        renderUsers();
    }

    public void renderUsers(){

        vboxContainer.getChildren().clear();

        for(User user : users){

            try {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "/co/edu/uniquindio/poo/evenly/AdminCardUser.fxml"
                        )
                );

                HBox card = loader.load();

                AdminCardUserController controller =
                        loader.getController();

                controller.setUser(user);

                vboxContainer
                        .getChildren()
                        .add(card);

            } catch (Exception e){

                e.printStackTrace();
            }
        }
    }

    @FXML
    void onChangeDashboard(MouseEvent event) {
        EvenlyApplication.changeScene("AdminDashboard.fxml");
    }

    @FXML
    void onChangeEvents(MouseEvent event) {
        EvenlyApplication.changeScene("AdminEvents.fxml");
    }

    @FXML
    void onChangeLogout(MouseEvent event) {

    }

    @FXML
    void onChangeReports(MouseEvent event) {

    }

    @FXML
    void onChangeSales(MouseEvent event) {
        EvenlyApplication.changeScene("AdminSales.fxml");
    }

}

