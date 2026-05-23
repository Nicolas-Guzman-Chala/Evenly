package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.SeatStatus;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.SeatZone;
import co.edu.uniquindio.poo.evenly.classes.model.*;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private Map<Button, Seat> seatMap =
            new HashMap<>();

    private List<Seat> selectedSeats =
            new ArrayList<>();

    @FXML
    public void initialize() {
        for(Node node : seatPane.getChildren()) {

            if(node instanceof Button button) {

                button.setOnAction(e -> {

                    handleSeat(button);

                });
            }
        }
    }

    private void loadSeats() {

        seatMap.clear();

        if(event.getSeats() == null || event.getSeats().isEmpty()) {

            for(Node node : seatPane.getChildren()) {

                if(node instanceof Button button) {

                    String code =
                            button.getId();

                    Seat seat =
                            createSeat(code);

                    event.getSeats().add(seat);
                }
            }
        }

        for(Node node : seatPane.getChildren()) {

            if(node instanceof Button button) {

                for(Seat seat : event.getSeats()) {

                    if(seat.getCode().equals(button.getId())) {

                        seatMap.put(button, seat);

                        updateSeatStyle(button, seat);

                        break;
                    }
                }
            }
        }

        updateTotal();
    }

    public void setEvent(Event event) {

        this.event = event;

        TextNameEvent.setText(
                event.getName()
        );

        TextDescription.setText(
                event.getDescription()
        );

        TextVenueAndCity.setText(
                event.getCity().toString()
        );

        textDate.setText(
                event.getDate().toString()
        );

        textHour.setText(
                event.getHour()
        );

        TextTypeCategory.setText(
                event.getCategory().toString()
        );

        textPriceVIP.setText(
                event.getPrice() + 60000 + ""
        );

        textPricePreferencial.setText(
                event.getPrice() + 40000 + ""
        );

        textPriceGeneral.setText(
                event.getPrice() + 20000 + ""
        );

        textPriceEconomy.setText(
                event.getPrice() + ""
        );

        TextService.setText(
                "$10000"
        );



        if(event.getImagePath() != null &&
                !event.getImagePath().isEmpty()) {

            File file =
                    new File(
                            event.getImagePath()
                    );

            imgEvent.setImage(
                    new Image(
                            file.toURI().toString()
                    )
            );

        } else {

            imgEvent.setImage(
                    new Image(
                            getClass().getResourceAsStream(
                                    "/co/edu/uniquindio/poo/evenly/imgs/BannerHero.png"
                            )
                    )
            );
        }

        loadSeats();
    }


    private Seat createSeat(String code) {

        SeatZone zone;

        double price;

        if(code.startsWith("A")) {

            zone = SeatZone.VIP;
            price = event.getPrice() + 60000;

        } else if(code.startsWith("B")) {

            zone = SeatZone.PREFERENCIAL;
            price = event.getPrice() + 40000;

        } else if(code.startsWith("C")) {

            zone = SeatZone.GENERAL;
            price = event.getPrice() + 20000;

        } else {

            zone = SeatZone.ECONOMY;
            price = event.getPrice();
        }

        return new Seat(
                code,
                zone,
                SeatStatus.AVAILABLE,
                price
        );
    }


    private void handleSeat(Button button) {

        Seat seat =
                seatMap.get(button);

        if(seat.getStatus() == SeatStatus.OCCUPIED ||
                seat.getStatus() == SeatStatus.DISABLED) {

            return;
        }

        if(seat.getStatus() == SeatStatus.SELECTED) {

            seat.setStatus(
                    SeatStatus.AVAILABLE
            );

            selectedSeats.remove(seat);

        } else {

            seat.setStatus(
                    SeatStatus.SELECTED
            );

            selectedSeats.add(seat);
        }

        updateSeatStyle(button, seat);

        updateTotal();
    }


    private void updateSeatStyle(Button button,
                                 Seat seat) {

        button.setDisable(false);

        switch (seat.getStatus()) {

            case AVAILABLE -> {

                switch (seat.getZone()) {

                    case VIP ->

                            button.setStyle(
                                    "-fx-background-color: #FFD700;" +
                                            "-fx-text-fill: black;" +
                                            "-fx-background-radius: 10;"
                            );

                    case PREFERENCIAL ->

                            button.setStyle(
                                    "-fx-background-color: #8000FF;" +
                                            "-fx-text-fill: white;" +
                                            "-fx-background-radius: 10;"
                            );

                    case GENERAL ->

                            button.setStyle(
                                    "-fx-background-color: #2196F3;" +
                                            "-fx-text-fill: white;" +
                                            "-fx-background-radius: 10;"
                            );

                    case ECONOMY ->

                            button.setStyle(
                                    "-fx-background-color: #4CAF50;" +
                                            "-fx-text-fill: white;" +
                                            "-fx-background-radius: 10;"
                            );
                }
            }

            case SELECTED ->

                    button.setStyle(
                            "-fx-background-color: #00C853;" +
                                    "-fx-text-fill: white;" +
                                    "-fx-background-radius: 10;"
                    );

            case OCCUPIED -> {

                button.setStyle(
                        "-fx-background-color: #D50000;" +
                                "-fx-text-fill: white;" +
                                "-fx-background-radius: 10;"
                );

                button.setDisable(true);
            }

            case DISABLED -> {

                button.setStyle(
                        "-fx-background-color: #757575;" +
                                "-fx-text-fill: white;" +
                                "-fx-background-radius: 10;"
                );

                button.setDisable(true);
            }
        }
    }


    private void updateTotal() {

        double total = 0;

        StringBuilder seatValues =
                new StringBuilder();

        Map<SeatZone, Double> zonePrices =
                new HashMap<>();

        int count = 0;

        for(Seat seat : selectedSeats) {

            total += seat.getPrice();

            seatValues
                    .append(seat.getCode())
                    .append("   ");

            count++;

            if(count % 7 == 0) {

                seatValues.append("\n");
            }

            zonePrices.putIfAbsent(
                    seat.getZone(),
                    seat.getPrice()
            );
        }

        StringBuilder seatPrices =
                new StringBuilder();

        for(Map.Entry<SeatZone, Double> entry
                : zonePrices.entrySet()) {

            seatPrices
                    .append(entry.getKey())
                    .append(" - $")
                    .append(entry.getValue())
                    .append("\n");
        }

        TextSeatValues.setText(
                seatValues.toString()
        );

        TextListPricesSeats.setText(
                seatPrices.toString()
        );

        TextSubTotal.setText(
                "$" + total
        );

        TextTotal.setText(
                "$" + (total + 10000)
        );
    }

    public List<Seat> getSelectedSeats() {

        return selectedSeats;
    }

    @FXML
    void onChangeEvents(MouseEvent event) {
        EvenlyApplication.changeScene("Events.fxml");
    }

    @FXML
    void onChangeHome(MouseEvent event) {
        EvenlyApplication.changeScene("Home.fxml");
    }

    @FXML
    void onChangeMerchandising(MouseEvent event) {

    }

    @FXML
    void onChangeProfile(MouseEvent event) {
        if(UserSession.getCurrentUser() == null) {

            EvenlyApplication.changeScene(
                    "Register.fxml"
            );

        } else {

            EvenlyApplication.changeScene(
                    "Profile.fxml"
            );
        }
    }

    @FXML
    void onContinueShopping(ActionEvent e) {
        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource(
                                    "/co/edu/uniquindio/poo/evenly/Payment.fxml"
                            )
                    );

            Parent root =
                    loader.load();

            PaymentController controller =
                    loader.getController();

            controller.setData(
                    this.event,
                    selectedSeats,
                    Double.parseDouble(
                            TextTotal.getText()
                                    .replace("$", "")
                    )
            );

            Scene scene =
                    new Scene(root);

            EvenlyApplication.getStage()
                    .setScene(scene);

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

}

