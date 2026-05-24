package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.CompraDecorator.CompraComponent;
import co.edu.uniquindio.poo.evenly.classes.model.CompraStatePackage.CompraState;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.PaymentMethod;
import com.google.gson.annotations.Expose;

import java.time.LocalDate;
import java.util.List;

public class Compra implements CompraComponent {

    private String idCompra;

    private LocalDate fechaCompra;

    private transient CompraState estado;

    @Expose(serialize = false, deserialize = false)
    private transient Event evento;

    private int idUser;

    private List<Entrada> entradas;

    private PaymentMethod paymentMethod;

    private Tarifa tarifa;

    /*
     * Snapshot del evento
     * para historial y persistencia
     */
    private String eventId;

    private String eventName;

    private String eventDescription;

    private String eventCategory;

    private String eventCity;

    private String eventDate;

    private String eventHour;

    private String eventImagePath;

    private String venueName;

    public Compra(String idCompra,
                  LocalDate fechaCompra,
                  CompraState estado,
                  int idUser,
                  Event evento,
                  PaymentMethod paymentMethod,
                  Tarifa tarifa,
                  List<Entrada> entradas) {

        this.idCompra = idCompra;

        this.fechaCompra = fechaCompra;

        this.estado = estado;

        this.idUser = idUser;

        this.evento = evento;

        this.paymentMethod = paymentMethod;

        this.tarifa = tarifa;

        this.entradas = entradas;

        /*
         * Snapshot del evento
         */
        if(evento != null) {

            this.eventId = evento.getId();

            this.eventName = evento.getName();

            this.eventDescription = evento.getDescription();

            this.eventCategory =
                    evento.getCategory().toString();

            this.eventCity =
                    evento.getCity().toString();

            this.eventDate =
                    evento.getDate().toString();

            this.eventHour =
                    evento.getHour();

            this.eventImagePath =
                    evento.getImagePath();

            if(evento.getRecinto() != null) {

                this.venueName =
                        evento.getRecinto().getNombre();
            }
        }
    }

    @Override
    public double calcularTotal() {

        double monto = 0;

        if(entradas == null) {
            return monto;
        }

        for (Entrada entrada : entradas) {

            double precioBase =
                    entrada
                            .getAsientoAsociado()
                            .getPrice();

            monto +=
                    tarifa.calcularPrecioFinal(
                            precioBase
                    );
        }

        return monto;
    }

    @Override
    public String mostrarDescripcion() {

        return "=== COMPRA ===" +
                "\nEvento: " + eventName +
                "\nEntradas: " +
                (entradas != null ? entradas.size() : 0) +
                "\nTotal: $" + calcularTotal();
    }

    /*
     * STATE
     */

    public void confirmar() {

        if (estado != null) {

            estado.confirmar(this);
        }
    }

    public void cancelar() {

        if (estado != null) {

            estado.cancelar(this);
        }
    }

    public void reembolsar() {

        if (estado != null) {

            estado.reembolsar(this);
        }
    }

    /*
     * CRUD ENTRADAS
     */

    public void agregarEntrada(Entrada entrada) {

        entradas.add(entrada);
    }

    public void eliminarEntrada(Entrada entrada) {

        entradas.remove(entrada);
    }

    /*
     * GETTERS
     */

    public String getIdCompra() {
        return idCompra;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public CompraState getEstado() {
        return estado;
    }

    public Event getEvento() {
        return evento;
    }

    public int getIdUser() {
        return idUser;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public PaymentMethod getMetodoPago() {
        return paymentMethod;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public String getEventCity() {
        return eventCity;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventHour() {
        return eventHour;
    }

    public String getEventImagePath() {
        return eventImagePath;
    }

    public String getVenueName() {
        return venueName;
    }

    /*
     * SETTERS
     */

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setEstado(CompraState estado) {
        this.estado = estado;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public void setEventCity(String eventCity) {
        this.eventCity = eventCity;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventHour(String eventHour) {
        this.eventHour = eventHour;
    }

    public void setEventImagePath(String eventImagePath) {
        this.eventImagePath = eventImagePath;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
}