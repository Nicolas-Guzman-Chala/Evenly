package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.*;
import co.edu.uniquindio.poo.evenly.classes.service.EventService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminReportsController implements Initializable {

    private final EventService eventService =
            Evenly.getInstance().getEventService();

    @FXML
    private TableView<EventSummaryDTO> EventManagementTable;

    @FXML
    private BarChart<String, Number> TableSalesSummary;

    @FXML
    private TableColumn<EventSummaryDTO, String> colCity;

    @FXML
    private TableColumn<EventSummaryDTO, String> colDate;

    @FXML
    private TableColumn<EventSummaryDTO, String> colEvent;

    @FXML
    private TableColumn<EventSummaryDTO, Double> colRevenue;

    @FXML
    private TableColumn<EventSummaryDTO, Integer> colTickets;

    @FXML
    private Label textEventsAmount;

    @FXML
    private Label textIncome;

    @FXML
    private Label textTicketsAmount;

    private ObservableList<EventSummaryDTO> data = FXCollections.observableArrayList();
    @FXML
    private ImageView imgUser;
    @FXML
    private Label textName;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String name = "Unknown";

        if (UserSession.getCurrentUser() != null &&
                UserSession.getCurrentUser().getFullName() != null &&
                !UserSession.getCurrentUser().getFullName().isBlank()) {

            name = UserSession.getCurrentUser().getFullName();
        }

        textName.setText(name);

        loadUserImage();
        setupTable();
        loadData();
        loadChart();
        loadSummary();
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


    private void setupTable() {

        colEvent.setCellValueFactory(new PropertyValueFactory<>("eventName"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTickets.setCellValueFactory(new PropertyValueFactory<>("ticketsSold"));
        colRevenue.setCellValueFactory(new PropertyValueFactory<>("revenue"));
    }

    private void loadData() {

        data.clear();

        List<Event> events = eventService.getEvents();

        for (Event e : events) {

            int ticketsSold = e.getSeats().stream()
                    .filter(seat -> !seat.isAvailable())
                    .toList().size();

            double revenue = ticketsSold * e.getPrice();

            data.add(new EventSummaryDTO(
                    e.getName(),
                    e.getCity().toString(),
                    e.getDate() != null ? e.getDate().toString() : "",
                    ticketsSold,
                    revenue
            ));
        }

        EventManagementTable.setItems(data);
    }

    private void loadChart() {

        TableSalesSummary.getData().clear();

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Revenue per Event");

        for (EventSummaryDTO dto : data) {

            series.getData().add(
                    new XYChart.Data<>(dto.getEventName(), dto.getRevenue())
            );
        }

        TableSalesSummary.getData().add(series);
    }

    private void loadSummary() {

        int totalEvents = data.size();

        int totalTickets = data.stream()
                .mapToInt(EventSummaryDTO::getTicketsSold)
                .sum();

        double totalIncome = data.stream()
                .mapToDouble(EventSummaryDTO::getRevenue)
                .sum();

        textEventsAmount.setText(String.valueOf(totalEvents));
        textTicketsAmount.setText(String.valueOf(totalTickets));
        textIncome.setText(String.valueOf(totalIncome));
    }

    @FXML
    void onChangeDashboard(MouseEvent event) { EvenlyApplication.changeScene("AdminDashboard.fxml");}
    @FXML
    void onChangeEventsAdmin(MouseEvent event) {EvenlyApplication.changeScene("AdminEvents.fxml");}
    @FXML
    void onChangeLogout(MouseEvent event) {EvenlyApplication.changeScene("AdminDashboard.fxml");}
    @FXML
    void onChangeNotificationAdmin(MouseEvent event) {}
    @FXML
    void onChangeReportsAdmin(MouseEvent event) {}
    @FXML
    void onChangeSalesAdmin(MouseEvent event) {EvenlyApplication.changeScene("AdminSales.fxml");}
    @FXML
    void onChangeUsersAdmin(MouseEvent event) {EvenlyApplication.changeScene("AdminUsers.fxml");}
    @FXML
    void onDownloadReport(ActionEvent event){
        System.out.println("Generando reporte PDF...");
        AdminReportPDFPrototype.generateReport(data);
    }
}