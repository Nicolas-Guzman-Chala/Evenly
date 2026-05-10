package co.edu.uniquindio.poo.evenly;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class AdminDashboardController {

    @FXML
    private TableView<?> EventManagementTable;

    @FXML
    private Label Events;

    @FXML
    private Label Reports;

    @FXML
    private Label Sales;

    @FXML
    private BarChart<?, ?> TableSalesSummary;

    @FXML
    private LineChart<?, ?> TableTicketsSummary;

    @FXML
    private Label TextSalesAmount;

    @FXML
    private Label TextSalesValue;

    @FXML
    private Label Users;

    @FXML
    private Label textName;

    @FXML
    private Label textProcentajeSales;

    @FXML
    void onChangeEventsAdmin(MouseEvent event) {
        EvenlyApplication.changeScene("AdminEvents.fxml");
    }

    @FXML
    void onChangeLogout(MouseEvent event) {

    }

    @FXML
    void onChangeNotificationAdmin(MouseEvent event) {

    }

    @FXML
    void onChangeReportsAdmin(MouseEvent event) {

    }

    @FXML
    void onChangeSalesAdmin(MouseEvent event) {
        EvenlyApplication.changeScene("AdminSales.fxml");
    }

    @FXML
    void onChangeUsersAdmin(MouseEvent event) {
        EvenlyApplication.changeScene("AdminUsers.fxml");
    }

}

