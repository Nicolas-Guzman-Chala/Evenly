package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.CompraDecorator.CompraComponent;
import co.edu.uniquindio.poo.evenly.classes.model.CompraStatePackage.CompraState;
import co.edu.uniquindio.poo.evenly.classes.model.CompraStrategy.PagoStrategy;


import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Compra implements CompraComponent {
    private String idCompra;
    private LocalDate fechaCompra;
    private double total;
    private CompraState estado;
    private User user;
    private Event evento;
    private List<Entrada> entradas;
    private PagoStrategy metodoPago;
    private Tarifa tarifa;


    public Compra(String idCompra, LocalDate fechaCompra,  CompraState estado, User user, Event evento, PagoStrategy metodoPago, Tarifa tarifa) {
        this.idCompra = idCompra;
        this.fechaCompra = fechaCompra;
        this.total = 0;
        this.estado = estado;
        this.user = user;
        this.evento = evento;
        this.entradas = new ArrayList<>();
        this.metodoPago = metodoPago;
        this.tarifa = tarifa;

    }
    public void agregarEntrada (Entrada entrada){
        entradas.add(entrada);
        System.out.println("se ha añadido una entrada a su compra");
    }
    public void eliminarEntrada (Entrada entrada){
        entradas.remove(entrada);
        System.out.println("se ha anulado una entrada");
    }


@Override
public double calcularTotal(){

    double monto = 0;

    for(Entrada e : entradas){

        double precioBase =
                e.getZonaAsociada()
                        .getPrecioBase();

        monto += tarifa
                .calcularPrecioFinal(
                        precioBase
                );
    }

    total = monto;

    return total;
}

    @Override
    public String mostrarDescripcion() {
        return "Compra del evento: "
                + evento.getName()
                + " | Entradas: "
                + entradas.size()
                + " | Total: $"
                + total;
    }


    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public CompraState getEstado() {
        return estado;
    }

    public void setEstado(CompraState estado) {
        this.estado = estado;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public PagoStrategy getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(PagoStrategy metodoPago) {
        this.metodoPago = metodoPago;
    }
}
