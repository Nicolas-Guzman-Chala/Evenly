package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.SeatStatus;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.SeatZone;

public class Seat {

    private String code;
    private SeatZone zone;
    private SeatStatus status;
    private double price;

    public Seat(String code,
                SeatZone zone,
                SeatStatus status,
                double price) {

        this.code = code;
        this.zone = zone;
        this.status = status;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public SeatZone getZone() {
        return zone;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }
}
