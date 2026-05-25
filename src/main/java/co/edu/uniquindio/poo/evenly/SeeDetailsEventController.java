package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.*;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.SeatStatus;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.SeatZone;
import co.edu.uniquindio.poo.evenly.classes.navigation.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.util.*;

public class SeeDetailsEventController {

    private Event event;

    @FXML
    private Label TextDescription;

    @FXML
    private Label TextListPricesSeats;

    @FXML
    private Label TextNameEvent;

    @FXML
    private Label TextSeatValues;

    @FXML
    private Label TextService;

    @FXML
    private Label TextSubTotal;

    @FXML
    private Label TextTotal;

    @FXML
    private Label TextTypeCategory;

    @FXML
    private Label TextVenueAndCity;

    @FXML
    private Label home;

    @FXML
    private ImageView imgEvent;

    @FXML
    private Label merchandising;

    @FXML
    private AnchorPane seatPane;

    @FXML
    private Label textDate;

    @FXML
    private Label textHour;

    @FXML
    private Label textPriceEconomy;

    @FXML
    private Label textPriceGeneral;

    @FXML
    private Label textPricePreferencial;

    @FXML
    private Label textPriceVIP;

    @FXML
    private ImageView user;

    private SceneManager sceneManager = new SceneManager();

    private Map<Button, Seat> seatMap = new HashMap<>();
    private List<Seat> selectedSeats = new ArrayList<>();

    @FXML
    public void initialize() {

        for (Node node : seatPane.getChildren()) {

            if (node instanceof Button button) {

                button.setOnAction(e -> handleSeat(button));
            }
        }
    }

    public void setEvent(Event event) {

        this.event = event;

        if (event == null) return;

        TextNameEvent.setText(event.getName());
        TextDescription.setText(event.getDescription());

        TextTypeCategory.setText(
                event.getCategory() != null ? event.getCategory().toString() : "N/A"
        );

        if (event.getRecinto() != null) {
            TextVenueAndCity.setText(
                    event.getRecinto().getNombre() + " - " +
                            event.getRecinto().getCity()
            );
        } else {
            TextVenueAndCity.setText("No venue");
        }

        textDate.setText(
                event.getDate() != null ? event.getDate().toString() : "No date"
        );

        textHour.setText(
                event.getHour() != null ? event.getHour().toString() : "No hour"
        );

        loadPrices();

        TextNameEvent.setText(event.getName());
        TextDescription.setText(event.getDescription());
        TextVenueAndCity.setText(event.getCity().toString());
        TextTypeCategory.setText(event.getCategory().toString());

        loadSeats();
    }

    private void loadPrices() {

        textPriceVIP.setText(event.getPrice() + 60000 + "");
        textPricePreferencial.setText(event.getPrice() + 40000 + "");
        textPriceGeneral.setText(event.getPrice() + 20000 + "");
        textPriceEconomy.setText(event.getPrice() + "");
    }

    private void loadSeats() {

        seatMap.clear();

        if (event.getSeats() == null) {
            event.setSeats(new ArrayList<>());
        }

        if (event.getSeats().isEmpty()) {

            for (Node node : seatPane.getChildren()) {

                if (node instanceof Button button) {

                    Seat seat = createSeat(button.getId());
                    event.getSeats().add(seat);
                }
            }
        }

        for (Node node : seatPane.getChildren()) {

            if (node instanceof Button button) {

                for (Seat seat : event.getSeats()) {

                    if (seat.getCode().equals(button.getId())) {

                        seatMap.put(button, seat);
                        updateSeatStyle(button, seat);
                    }
                }
            }
        }

        updateTotal();
    }

    private Seat createSeat(String code) {

        SeatZone zone;
        double price;

        if (code.startsWith("A")) {
            zone = SeatZone.VIP;
            price = event.getPrice() + 60000;

        } else if (code.startsWith("B")) {
            zone = SeatZone.PREFERENCIAL;
            price = event.getPrice() + 40000;

        } else if (code.startsWith("C")) {
            zone = SeatZone.GENERAL;
            price = event.getPrice() + 20000;

        } else {
            zone = SeatZone.ECONOMY;
            price = event.getPrice();
        }

        return new Seat(code, zone, price, SeatStatus.AVAILABLE);
    }

    private void handleSeat(Button button) {

        Seat seat = seatMap.get(button);

        if (seat.getStatus() == SeatStatus.OCCUPIED ||
                seat.getStatus() == SeatStatus.DISABLED) {
            return;
        }

        if (seat.getStatus() == SeatStatus.SELECTED) {

            seat.setStatus(SeatStatus.AVAILABLE);
            selectedSeats.remove(seat);

        } else {

            seat.setStatus(SeatStatus.SELECTED);
            selectedSeats.add(seat);
        }

        updateSeatStyle(button, seat);
        updateTotal();
    }

    private void updateSeatStyle(Button button, Seat seat) {

        button.setDisable(false);

        SeatStatus status = seat.getStatus();

        if (status == null) {
            seat.setStatus(SeatStatus.AVAILABLE);
            status = SeatStatus.AVAILABLE;
        }

        if (status == SeatStatus.OCCUPIED) {
            button.setStyle("-fx-background-color: #D50000;");
            button.setDisable(true);
            return;
        }

        if (status == SeatStatus.SELECTED) {
            button.setStyle("-fx-background-color: #00C853;");
            return;
        }

        switch (seat.getZone()) {

            case VIP -> button.setStyle("-fx-background-color: #FFD700;");
            case PREFERENCIAL -> button.setStyle("-fx-background-color: #8000FF;");
            case GENERAL -> button.setStyle("-fx-background-color: #2196F3;");
            case ECONOMY -> button.setStyle("-fx-background-color: #4CAF50;");
        }
    }

    private void updateTotal() {

        double total = 0;
        StringBuilder seatsText = new StringBuilder();

        int count = 0;

        for (Seat seat : selectedSeats) {

            total += seat.getPrice();

            seatsText.append(seat.getCode()).append(" ");
            count++;

            if (count % 7 == 0) {
                seatsText.append("\n");
            }
        }

        TextSeatValues.setText(seatsText.toString().trim());
        TextSubTotal.setText("$" + total);
        TextTotal.setText("$" + (total + 10000));
    }

    @FXML
    void onChangeHome(MouseEvent event) {
        EvenlyApplication.changeScene("Home.fxml");
    }

    @FXML
    void onChangeEvents(MouseEvent event) {
        EvenlyApplication.changeScene("Events.fxml");
    }

    @FXML
    void onChangeProfile(MouseEvent event){
        if(UserSession.getCurrentUser() == null){

            sceneManager.openRegister();

        } else {

            sceneManager.openProfile();
        }
    }

    @FXML
    void onChangeMerchandising(MouseEvent event){

    }

    @FXML
    void onContinueShopping(ActionEvent e) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/co/edu/uniquindio/poo/evenly/Payment.fxml")
            );

            Parent root = loader.load();

            PaymentController controller = loader.getController();

            controller.setData(
                    event,
                    selectedSeats,
                    Double.parseDouble(TextTotal.getText().replace("$", ""))
            );

            EvenlyApplication.getStage().setScene(new Scene(root));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}