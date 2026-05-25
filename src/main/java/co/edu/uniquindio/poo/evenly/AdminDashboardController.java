package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.*;
import co.edu.uniquindio.poo.evenly.classes.service.EventService;
import co.edu.uniquindio.poo.evenly.classes.service.UserService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class AdminDashboardController {

    private final UserService userService =
            new UserService();

    private final EventService eventService =
            new EventService();

    @FXML
    private TableView<EventSummaryDTO> EventManagementTable;

    @FXML
    private TableColumn<EventSummaryDTO, String> colEvent;

    @FXML
    private TableColumn<EventSummaryDTO, String> colCity;

    @FXML
    private TableColumn<EventSummaryDTO, String> colDate;

    @FXML
    private TableColumn<EventSummaryDTO, Integer> colTickets;

    @FXML
    private TableColumn<EventSummaryDTO, Double> colRevenue;

    @FXML
    private Label Events;

    @FXML
    private Label Reports;

    @FXML
    private Label Sales;

    @FXML
    private BarChart<String, Number> TableSalesSummary;

    @FXML
    private LineChart<String, Number> TableTicketsSummary;

    @FXML
    private Label TextSalesAmount;

    @FXML
    private Label TextSalesValue;

    @FXML
    private Label Users;

    @FXML
    private ImageView imgUser;

    @FXML
    private Label textProcentajeSales;

    @FXML
    private Label textName;


    @FXML
    public void initialize() {

        String name = "Unknown";

        if (UserSession.getCurrentUser() != null &&
                UserSession.getCurrentUser().getFullName() != null &&
                !UserSession.getCurrentUser().getFullName().isBlank()) {

            name = UserSession.getCurrentUser().getFullName();
        }

        textName.setText(name);

        loadUserImage();

        initializeTable();

        loadDashboardData();

        loadCharts();

    }

    private void loadUserImage() {

        User user = UserSession.getCurrentUser();

        if (user == null || user.getImagePath() == null || user.getImagePath().isBlank()) {
            return;
        }

        File file = new File(user.getImagePath());

        if (!file.exists()) {
            return;
        }

        imgUser.setImage(new Image(file.toURI().toString()));
    }

    private void initializeTable() {

        colEvent.setCellValueFactory(
                new PropertyValueFactory<>("eventName")
        );

        colCity.setCellValueFactory(
                new PropertyValueFactory<>("city")
        );

        colDate.setCellValueFactory(
                new PropertyValueFactory<>("date")
        );

        colTickets.setCellValueFactory(
                new PropertyValueFactory<>("ticketsSold")
        );

        colRevenue.setCellValueFactory(
                new PropertyValueFactory<>("revenue")
        );
    }

    private void loadDashboardData() {

        ObservableList<EventSummaryDTO> list =
                FXCollections.observableArrayList();

        int totalTickets = 0;

        double totalRevenue = 0;

        for(Event event : eventService.getEvents()) {

            int soldTickets = 0;

            double revenue = 0;

            for(User user : userService.getUsers()) {

                for(Compra compra :
                        user.getPurchaseHistory()) {

                    if(compra.getEventId() == null) {
                        continue;
                    }

                    if(compra.getEventId()
                            .equals(event.getId())) {

                        soldTickets +=
                                compra.getEntradas().size();

                        revenue +=
                                compra.calcularTotal();
                    }
                }
            }

            totalTickets += soldTickets;

            totalRevenue += revenue;

            list.add(

                    new EventSummaryDTO(

                            event.getName(),

                            event.getCity().toString(),

                            event.getDate().toString(),

                            soldTickets,

                            revenue
                    )
            );
        }

        EventManagementTable.setItems(list);

        TextSalesAmount.setText(
                String.valueOf(totalTickets)
        );

        TextSalesValue.setText(
                "$" + totalRevenue
        );

        textProcentajeSales.setText(
                "+12%"
        );
    }

    private void loadCharts() {

        XYChart.Series<String, Number> salesSeries =
                new XYChart.Series<>();

        salesSeries.setName("Revenue");

        XYChart.Series<String, Number> ticketsSeries =
                new XYChart.Series<>();

        ticketsSeries.setName("Tickets");

        for(Event event : eventService.getEvents()) {

            int soldTickets = 0;

            double revenue = 0;

            for(User user : userService.getUsers()) {

                for(Compra compra :
                        user.getPurchaseHistory()) {

                    if(compra.getEventId() == null) {
                        continue;
                    }

                    if(compra.getEventId()
                            .equals(event.getId())) {

                        soldTickets +=
                                compra.getEntradas().size();

                        revenue +=
                                compra.calcularTotal();
                    }
                }
            }

            salesSeries.getData().add(

                    new XYChart.Data<>(

                            event.getName(),

                            revenue
                    )
            );

            ticketsSeries.getData().add(

                    new XYChart.Data<>(

                            event.getName(),

                            soldTickets
                    )
            );
        }

        TableSalesSummary.getData().clear();

        TableSalesSummary.getData().add(
                salesSeries
        );

        TableTicketsSummary.getData().clear();

        TableTicketsSummary.getData().add(
                ticketsSeries
        );
    }

    @FXML
    void onChangeEventsAdmin(MouseEvent event) {

        EvenlyApplication.changeScene(
                "AdminEvents.fxml"
        );
    }

    @FXML
    void onChangeLogout(MouseEvent event) {
        EvenlyApplication.changeScene(
                "Login.fxml"
        );
    }

    @FXML
    void onChangeNotificationAdmin(MouseEvent event) {

    }

    @FXML
    void onChangeReportsAdmin(MouseEvent event) {
     EvenlyApplication.changeScene("AdminReports.fxml");
    }

    @FXML
    void onChangeSalesAdmin(MouseEvent event) {

        EvenlyApplication.changeScene(
                "AdminSales.fxml"
        );
    }

    @FXML
    void onChangeUsersAdmin(MouseEvent event) {

        EvenlyApplication.changeScene(
                "AdminUsers.fxml"
        );
    }
}