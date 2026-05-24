package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEntrada;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.SeatZone;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.TipoZona;

import java.util.UUID;

public class Entrada {

    private final String idEntrada;
    private Event eventoAsociado;
    private SeatZone zonaAsociada;
    private Seat asientoAsociado;
    private SeatZone categoriaEntrada;
    private EstadoEntrada estadoEntrada;

    public Entrada(String idEntrada,
                   Event eventoAsociado,
                   SeatZone zonaAsociada,
                   Seat asientoAsociado,
                   SeatZone categoriaEntrada,
                   EstadoEntrada estadoEntrada) {

        this.idEntrada = UUID.randomUUID().toString();
        this.eventoAsociado = eventoAsociado;
        this.zonaAsociada = zonaAsociada;
        this.asientoAsociado = asientoAsociado;
        this.categoriaEntrada = categoriaEntrada;
        this.estadoEntrada = estadoEntrada;
    }

    public String getIdEntrada() {
        return idEntrada;
    }

    public Event getEventoAsociado() {
        return eventoAsociado;
    }

    public void setEventoAsociado(Event eventoAsociado) {
        this.eventoAsociado = eventoAsociado;
    }

    public SeatZone getZonaAsociada() {
        return zonaAsociada;
    }

    public void setZonaAsociada(SeatZone zonaAsociada) {
        this.zonaAsociada = zonaAsociada;
    }

    public Seat getAsientoAsociado() {
        return asientoAsociado;
    }

    public void setAsientoAsociado(Seat asientoAsociado) {
        this.asientoAsociado = asientoAsociado;
    }

    public SeatZone getCategoriaEntrada() {
        return categoriaEntrada;
    }

    public void setCategoriaEntrada(SeatZone categoriaEntrada) {
        this.categoriaEntrada = categoriaEntrada;
    }

    public EstadoEntrada getEstadoEntrada() {
        return estadoEntrada;
    }

    public void setEstadoEntrada(EstadoEntrada estadoEntrada) {
        this.estadoEntrada = estadoEntrada;
    }
}