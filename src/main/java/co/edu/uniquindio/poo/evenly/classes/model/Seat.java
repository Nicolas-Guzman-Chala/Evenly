package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.AsientoState.AsientoState;
import co.edu.uniquindio.poo.evenly.classes.model.AsientoState.DisponibleState;
import co.edu.uniquindio.poo.evenly.classes.model.AsientoState.VendidoState;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.SeatStatus;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.SeatZone;
import com.google.gson.annotations.Expose;

public class Seat {

    private final String code;

    private SeatStatus status;

    private final SeatZone zone;

    private double price;

    @Expose(serialize = false, deserialize = false)
    private transient AsientoState state;

    public Seat(String code,
                SeatZone zone,
                double price,
                SeatStatus status) {

        this.code = code;
        this.zone = zone;
        this.price = price;
        this.status = status;

        initializeState();
    }

    public void initializeState() {

        if (status == SeatStatus.OCCUPIED) {

            this.state = new VendidoState();

        } else {

            this.state = new DisponibleState();
        }
    }

    public boolean comprar() {

        if(state == null){
            initializeState();
        }

        return state.comprar(this);
    }

    public boolean bloquear() {

        if(state == null){
            initializeState();
        }

        return state.bloquear(this);
    }

    public String getEstadoNombre() {

        if(state == null){
            initializeState();
        }

        return state.getNombreEstado();
    }

    public String getCode() {
        return code;
    }

    public SeatZone getZone() {
        return zone;
    }

    public double getPrice() {
        return price;
    }

    public AsientoState getState() {

        if(state == null){
            initializeState();
        }

        return state;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setState(AsientoState state) {
        this.state = state;
    }

    public void marcarComoOcupado() {

        this.status = SeatStatus.OCCUPIED;

        this.state = new VendidoState();
    }

    public void marcarComoComprado() {

        this.status = SeatStatus.OCCUPIED;

        this.state = new VendidoState();
    }

    public boolean isAvailable() {
        return status == SeatStatus.AVAILABLE;
    }

    public void reservar() {

        this.status = SeatStatus.OCCUPIED;

        this.state = new VendidoState();
    }

    public void liberar() {

        this.status = SeatStatus.AVAILABLE;

        this.state = new DisponibleState();
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {

        this.status = status;

        initializeState();
    }
}