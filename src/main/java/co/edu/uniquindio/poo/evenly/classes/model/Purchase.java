package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.PaymentMethod;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {

    private String userEmail;
    private String eventId;
    private String eventName;
    private List<String> seatCodes;
    private PaymentMethod paymentMethod;
    private double total;
    private LocalDateTime purchaseDate;

    public Purchase(String userEmail,
                    String eventId,
                    String eventName,
                    List<String> seatCodes,
                    PaymentMethod paymentMethod,
                    double total,
                    LocalDateTime purchaseDate) {

        this.userEmail = userEmail;
        this.eventId = eventId;
        this.eventName = eventName;
        this.seatCodes = seatCodes;
        this.paymentMethod = paymentMethod;
        this.total = total;
        this.purchaseDate = purchaseDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public List<String> getSeatCodes() {
        return seatCodes;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public double getTotal() {
        return total;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }
}