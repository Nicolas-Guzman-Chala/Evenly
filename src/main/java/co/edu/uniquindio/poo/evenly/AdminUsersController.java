package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;
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
    private VBox vBoxContainerRecent;

    @FXML
    private VBox vboxContainer;

    @FXML
    public void initialize(){

        users = userService.getUsers();

        users.sort((u1, u2) -> {

            double total1 = 0;
            double total2 = 0;

            if(u1.getPurchaseHistory() != null){

                for(Compra compra : u1.getPurchaseHistory()){

                    total1 += compra.calcularTotal();
                }
            }

            if(u2.getPurchaseHistory() != null){

                for(Compra compra : u2.getPurchaseHistory()){

                    total2 += compra.calcularTotal();
                }
            }

            return Double.compare(total2, total1);
        });

        renderUsers();

        renderRecentUsers();

        setDashboardInfo();
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

    public void renderRecentUsers(){

        vBoxContainerRecent.getChildren().clear();

        int limit = Math.min(users.size(), 5);

        for(int i = 0; i < limit; i++){

            User user = users.get(i);

            try {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "/co/edu/uniquindio/poo/evenly/AdminCardUserRecent.fxml"
                        )
                );

                HBox card = loader.load();

                AdminCardUserRecentController controller =
                        loader.getController();

                controller.setUser(user);

                vBoxContainerRecent
                        .getChildren()
                        .add(card);

            } catch (Exception e){

                e.printStackTrace();
            }
        }
    }

    public void setDashboardInfo(){

        int totalUsers = users.size();

        int totalTickets = 0;

        double totalIncome = 0;

        for(User user : users){

            if(user.getPurchaseHistory() != null){

                for(Compra compra : user.getPurchaseHistory()){

                    totalTickets += compra.getEntradas().size();

                    totalIncome += compra.calcularTotal();
                }
            }
        }
    }

    @FXML
    void onChangeDashboard(MouseEvent event) {

        EvenlyApplication.changeScene(
                "AdminDashboard.fxml"
        );
    }

    @FXML
    void onChangeEvents(MouseEvent event) {

        EvenlyApplication.changeScene(
                "AdminEvents.fxml"
        );
    }

    @FXML
    void onChangeLogout(MouseEvent event) {

    }

    @FXML
    void onChangeReports(MouseEvent event) {

    }

    @FXML
    void onChangeSales(MouseEvent event) {

        EvenlyApplication.changeScene(
                "AdminSales.fxml"
        );
    }
}