package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.*;
import co.edu.uniquindio.poo.evenly.classes.service.EventService;
import co.edu.uniquindio.poo.evenly.classes.service.UserService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.util.*;

public class AdminSalesController {

    @FXML
    private ImageView imgUser;

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private TableView<SaleDTO> tableView;

    @FXML
    private TableColumn<SaleDTO, String> colUser;

    @FXML
    private TableColumn<SaleDTO, LocalDate> colDate;

    @FXML
    private TableColumn<SaleDTO, Double> colTotal;

    @FXML
    private Label textName;

    @FXML
    private Label textPorcentaje;

    @FXML
    private Label textSalesAmount;

    @FXML
    private Label textSalesValue;

    private final UserService userService = new UserService();

    @FXML
    public void initialize() {

        setupTable();
        loadSales();
        loadChart();
    }

    private void setupTable() {

        colUser.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    private void loadSales() {

        List<SaleDTO> sales = new ArrayList<>();

        double totalRevenue = 0;

        for (User user : userService.getUsers()) {

            if (user.getPurchaseHistory() == null) continue;

            for (Compra compra : user.getPurchaseHistory()) {

                SaleDTO dto = new SaleDTO(
                        user.getFullName(),
                        LocalDate.now(),
                        compra.calcularTotal()
                );

                sales.add(dto);

                totalRevenue += compra.calcularTotal();
            }
        }

        tableView.setItems(FXCollections.observableArrayList(sales));

        textSalesValue.setText("$ " + totalRevenue);
        textSalesAmount.setText(String.valueOf(sales.size()));
    }

    private void loadChart() {

        Map<String, Double> salesByDay = new HashMap<>();

        for (User user : userService.getUsers()) {

            if (user.getPurchaseHistory() == null) continue;

            for (Compra compra : user.getPurchaseHistory()) {

                String day = LocalDate.now().toString(); // cámbialo si tienes fecha real

                salesByDay.put(
                        day,
                        salesByDay.getOrDefault(day, 0.0) + compra.calcularTotal()
                );
            }
        }

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Sales");

        for (Map.Entry<String, Double> entry : salesByDay.entrySet()) {

            series.getData().add(
                    new XYChart.Data<>(entry.getKey(), entry.getValue())
            );
        }

        lineChart.getData().clear();
        lineChart.getData().add(series);
    }

    @FXML void onChangeDashboard(MouseEvent event) { EvenlyApplication.changeScene("AdminDashboard.fxml");}
    @FXML void onChangeEvents(MouseEvent event) { EvenlyApplication.changeScene("AdminEvents.fxml");}
    @FXML void onChangeLogout(MouseEvent event) { EvenlyApplication.changeScene("Login.fxml");}
    @FXML void onChangeReports(MouseEvent event) { }
    @FXML void onChangeUsers(MouseEvent event) { EvenlyApplication.changeScene("AdminUsers.fxml");}
}