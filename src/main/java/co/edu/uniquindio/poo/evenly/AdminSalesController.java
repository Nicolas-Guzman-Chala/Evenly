package co.edu.uniquindio.poo.evenly;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class AdminSalesController {

    @FXML
    private Label imgUser;

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private TableView<?> tableView;

    @FXML
    private Label textName;

    @FXML
    private Label textSalesAmount;

    @FXML
    private Label textValue2;

    @FXML
    private Label textValue3;

    @FXML
    private VBox vBoxContainer;

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
    void onChangeUsers(MouseEvent event) {
        EvenlyApplication.changeScene("AdminUsers.fxml");
    }

}

