package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.*;
import co.edu.uniquindio.poo.evenly.classes.model.AsientoState.VendidoState;
import co.edu.uniquindio.poo.evenly.classes.model.CompraStatePackage.PagadoState;
import co.edu.uniquindio.poo.evenly.classes.model.CompraStrategy.PagoMasterCard;
import co.edu.uniquindio.poo.evenly.classes.model.CompraStrategy.PagoPSE;
import co.edu.uniquindio.poo.evenly.classes.model.CompraStrategy.PagoPaypal;
import co.edu.uniquindio.poo.evenly.classes.model.CompraStrategy.PagoStrategy;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.*;
import co.edu.uniquindio.poo.evenly.classes.model.Proxy.*;
import co.edu.uniquindio.poo.evenly.classes.service.EventService;
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

    @FXML private Label AmountTotal;
    @FXML private Label DateAndHourEvent;
    @FXML private Label SeatsValues;
    @FXML private Label TextNameEvent;
    @FXML private Label TotalAmount;

    @FXML private AnchorPane cardPayment;
    @FXML private AnchorPane CardPayment2;
    @FXML private AnchorPane CardPayment3;

    @FXML private DatePicker datePicker;

    @FXML private TextField inputCountry;
    @FXML private TextField inputNameCard;
    @FXML private TextField inputNumberCard;
    @FXML private TextField inputPostcode;

    @FXML private ImageView imgUser;

    private Event event;
    private List<Seat> seats;
    private PaymentMethod selectedPaymentMethod;
    private AnchorPane selectedPayment;

    private final EventService eventService = new EventService();
    private final UserService userService = new UserService();

    private final CompraService compraService =
            new CompraProxy(new CompraServiceReal());

    @FXML
    public void initialize() {
        resetStyles();
        selectPayment(cardPayment);
        selectedPaymentMethod = PaymentMethod.MASTERCARD;
    }

    public void setData(Event event, List<Seat> seats, double total) {

        this.event = event;
        this.seats = seats;

        TextNameEvent.setText(event.getName());
        DateAndHourEvent.setText(event.getDate() + " - " + event.getHour());

        TotalAmount.setText("$" + total);
        AmountTotal.setText("$" + total);

        StringBuilder seatText = new StringBuilder();
        for (Seat seat : seats) {
            seatText.append(seat.getCode()).append(" ");
        }

        SeatsValues.setText(seatText.toString());
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

        if (UserSession.getCurrentUser() == null) {
            EvenlyApplication.changeScene("Register.fxml");
        } else {
            EvenlyApplication.changeScene("Profile.fxml");
        }
    }

    @FXML
    void onClickPayment(MouseEvent event) {

        AnchorPane selected = (AnchorPane) event.getSource();
        selectPayment(selected);

        if (selected == cardPayment) {
            selectedPaymentMethod = PaymentMethod.MASTERCARD;
        } else if (selected == CardPayment2) {
            selectedPaymentMethod = PaymentMethod.PAYPAL;
        } else {
            selectedPaymentMethod = PaymentMethod.PSE;
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

        if (!validarFormulario()) return;

        User user = UserSession.getCurrentUser();

        Compra compra = crearCompraDominio(user);

        compraService.realizarCompra(compra);
        compraService.pagarCompra(compra);

        actualizarAsientos();

        if(user.getPurchaseHistory() == null){
            user.setPurchaseHistory(new ArrayList<>());
        }

        user.getPurchaseHistory().add(compra);

        actualizarUsuario(user);

        eventService.updateEvent(event.getId(), event);

        EvenlyApplication.changeScene("Home.fxml");
    }

    private boolean validarFormulario() {

        if (UserSession.getCurrentUser() == null) {
            EvenlyApplication.changeScene("Register.fxml");
            return false;
        }

        if (seats == null || seats.isEmpty()) {
            System.out.println("Select at least one seat");
            return false;
        }

        if (inputNameCard.getText().isEmpty() ||
                inputNumberCard.getText().isEmpty() ||
                inputCountry.getText().isEmpty() ||
                inputPostcode.getText().isEmpty() ||
                datePicker.getValue() == null) {

            System.out.println("Complete all fields");
            return false;
        }

        return true;
    }

    private SeatZone map(SeatZone zone) {

        switch(zone) {
            case VIP: return SeatZone.VIP;
            case GENERAL: return SeatZone.GENERAL;
            case PREFERENCIAL: return SeatZone.PREFERENCIAL;
            default: return SeatZone.ECONOMY;
        }
    }


    private Compra crearCompraDominio(User user) {

        List<Entrada> entradas = new ArrayList<>();

        for (Seat seat : seats) {

            Entrada entrada = new Entrada(
                    "E-" + System.nanoTime(),
                    event,
                    null,
                    seat,
                    map(seat.getZone()),
                    EstadoEntrada.ACTIVA
            );

            entradas.add(entrada);
        }

        PagoStrategy pagoStrategy = crearEstrategia(selectedPaymentMethod);

        return new Compra(
                "C-" + System.currentTimeMillis(),
                LocalDateTime.now().toLocalDate(),
                new PagadoState(),
                user.getIdUser(),
                event,
                selectedPaymentMethod,
                new Tarifa(0,10000,0),
                entradas
        );
    }

    private PagoStrategy crearEstrategia(PaymentMethod method) {

        switch (method) {

            case MASTERCARD:
                return new PagoMasterCard();

            case PAYPAL:
                return new PagoPaypal();

            case PSE:
                return new PagoPSE();

            default:
                throw new IllegalArgumentException("Método no soportado");
        }
    }

    private void actualizarUsuario(User user) {

        if (user.getPurchaseHistory() == null) {
            user.setPurchaseHistory(new ArrayList<>());
        }

        userService.updateUser(user.getIdUser(), user);
    }

    private void actualizarAsientos() {

        for (Seat seatComprado : seats) {

            for (Seat seatEvento : event.getSeats()) {

                if(seatEvento.getCode().equals(seatComprado.getCode())) {

                    seatEvento.marcarComoOcupado();
                }
            }
        }
    }
}