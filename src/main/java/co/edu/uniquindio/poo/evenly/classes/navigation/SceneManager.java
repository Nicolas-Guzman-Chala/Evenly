package co.edu.uniquindio.poo.evenly.classes.navigation;

import co.edu.uniquindio.poo.evenly.EvenlyApplication;

public class SceneManager {

    public void openLogin() {

        EvenlyApplication.changeScene(
                "Login.fxml"
        );
    }

    public void openRegister() {

        EvenlyApplication.changeScene(
                "Register.fxml"
        );
    }

    public void openHome(){

        EvenlyApplication.changeScene(
                "Home.fxml"
        );
    }

    public void openEvents(){

        EvenlyApplication.changeScene(
                "Events.fxml"
        );
    }

    public void openProfile(){

        EvenlyApplication.changeScene(
                "UserInformation.fxml"
        );
    }

    public void openAdminDashboard() {

        EvenlyApplication.changeScene(
                "AdminDashboard.fxml"
        );
    }

    public void openAdminEvents() {

        EvenlyApplication.changeScene(
                "AdminEvents.fxml"
        );
    }

    public void openAdminSales() {

        EvenlyApplication.changeScene(
                "AdminSales.fxml"
        );
    }

    public void openAdminUsers() {

        EvenlyApplication.changeScene(
                "AdminUsers.fxml"
        );
    }

    public void logout() {

        openLogin();
    }
}