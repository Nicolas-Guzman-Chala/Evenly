package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.*;
import co.edu.uniquindio.poo.evenly.classes.service.EventService;
import co.edu.uniquindio.poo.evenly.classes.service.PurchaseService;
import co.edu.uniquindio.poo.evenly.classes.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PaymentController {

    @FXML
    private Label AmountTotal;

    @FXML
    private AnchorPane CardPayment2;

    @FXML
    private AnchorPane CardPayment3;

    @FXML
    private Label DateAndHourEvent;

    @FXML
    private Label SeatsValues;

    @FXML
    private Label TextNameEvent;

    @FXML
    private Label TotalAmount;

    @FXML
    private AnchorPane cardPayment;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label events;

    @FXML
    private Label home;

    @FXML
    private ImageView imgUser;

    @FXML
    private TextField inputCountry;

    @FXML
    private TextField inputNameCard;

    @FXML
    private TextField inputNumberCard;

    @FXML
    private TextField inputPostcode;

    @FXML
    private Label merchandising;

    private AnchorPane selectedPayment;

    private Event event;

    private List<Seat> seats;

    private PaymentMethod selectedPaymentMethod;

    private EventService eventService =
            new EventService();

    private UserService userService = new UserService();

    private PurchaseService purchaseService =
            new PurchaseService();

    @FXML
    public void initialize() {

        resetStyles();

        selectPayment(cardPayment);

        selectedPaymentMethod =
                PaymentMethod.MASTERCARD;
    }

    public void setData(Event event,
                        List<Seat> seats,
                        double total) {

        this.event = event;
        this.seats = seats;

        TextNameEvent.setText(
                event.getName()
        );

        DateAndHourEvent.setText(
                event.getDate() +
                        " - " +
                        event.getHour()
        );

        TotalAmount.setText(
                "$" + total
        );

        AmountTotal.setText(
                "$" + total
        );

        StringBuilder seatText =
                new StringBuilder();

        for(Seat seat : seats) {

            seatText
                    .append(seat.getCode())
                    .append(" ");
        }

        SeatsValues.setText(
                seatText.toString()
        );
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
        EvenlyApplication.changeScene("Merchandising.fxml");
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
    void onClickPayment(MouseEvent event) {

        AnchorPane selected =
                (AnchorPane) event.getSource();

        selectPayment(selected);

        if(selected == cardPayment) {

            selectedPaymentMethod =
                    PaymentMethod.MASTERCARD;

        } else if(selected == CardPayment2) {

            selectedPaymentMethod =
                    PaymentMethod.PAYPAL;

        } else {

            selectedPaymentMethod =
                    PaymentMethod.PSE;
        }
    }

    private void selectPayment(AnchorPane payment) {

        resetStyles();

        selectedPayment = payment;

        payment.setStyle(
                "-fx-background-color: #1E1B4B;" +
                        "-fx-border-color: #B135D0;" +
                        "-fx-border-width: 2;" +
                        "-fx-background-radius: 15;" +
                        "-fx-border-radius: 15;"
        );
    }

    private void resetStyles() {

        String normalStyle =
                "-fx-background-color: #11111D;" +
                        "-fx-border-color: #2A2A3A;" +
                        "-fx-border-width: 1;" +
                        "-fx-background-radius: 15;" +
                        "-fx-border-radius: 15;";

        cardPayment.setStyle(normalStyle);

        CardPayment2.setStyle(normalStyle);

        CardPayment3.setStyle(normalStyle);
    }

    @FXML
    void onPayNow(ActionEvent e) {

        if(UserSession.getCurrentUser() == null) {

            EvenlyApplication.changeScene(
                    "Register.fxml"
            );

            return;
        }

        if(seats == null || seats.isEmpty()) {

            System.out.println(
                    "Select at least one seat"
            );

            return;
        }

        if(inputNameCard.getText().isEmpty() ||
                inputNumberCard.getText().isEmpty() ||
                inputCountry.getText().isEmpty() ||
                inputPostcode.getText().isEmpty() ||
                datePicker.getValue() == null) {

            System.out.println(
                    "Complete all fields"
            );

            return;}

        double total = 0;

        for(Seat seat : seats) {

            total += seat.getPrice();
        }

        total += 10000;

        List<String> seatCodes =
                new ArrayList<>();

        for(Seat seat : seats) {

            seatCodes.add(
                    seat.getCode()
            );
        }

        Purchase purchase =
                new Purchase(
                        UserSession
                                .getCurrentUser()
                                .getEmail(),

                        event.getId(),

                        event.getName(),

                        seatCodes,

                        selectedPaymentMethod,

                        total,

                        LocalDateTime.now()
                );

        purchaseService.savePurchase(
                purchase
        );

        User user =
                UserSession.getCurrentUser();

        if(user.getPurchaseHistory() == null) {

            user.setPurchaseHistory(
                    new ArrayList<>()
            );
        }

        user.getPurchaseHistory().add(
                purchase
        );

        userService.updateUser(
                user.getIdUser(),
                user
        );

        System.out.println(
                "Successful payment"
        );

        for(Seat seat : seats) {

            seat.setStatus(
                    SeatStatus.OCCUPIED
            );
        }

        eventService.updateEvent(
                event.getId(),
                event
        );

        EvenlyApplication.changeScene(
                "Home.fxml"
        );
    }
}