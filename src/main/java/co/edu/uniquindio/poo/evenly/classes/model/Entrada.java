package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEntrada;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.TipoZona;

public class Entrada {
    private String idEntrada;
    private Event eventoAsociado;
    private Zona zonaAsociada;
    private Asiento asientoAsociado;
    private TipoZona categoriaEntrada;
    private EstadoEntrada estadoEntrada;

    public Entrada (String id, Event eventoAsociado,Zona zonaAsociada, Asiento asientoAsociado, TipoZona categoriaEntrada, EstadoEntrada estadoEntrada) {
        this.idEntrada = id;
        this.eventoAsociado = eventoAsociado;
        this.asientoAsociado = asientoAsociado;
        this.categoriaEntrada = categoriaEntrada;
        this.estadoEntrada = estadoEntrada;
        this.zonaAsociada = zonaAsociada;

    }



    public String consultarEntrada() {

        return "ENTRADA" +
                "\nID: " + idEntrada +
                "\nEvento: " + eventoAsociado.getName() +
                "\nAsiento: " + asientoAsociado.getFila()
                + asientoAsociado.getNumero() +
                "\nCategoria: " + categoriaEntrada +
                "\nEstado: " + estadoEntrada;
    }

    public Zona getZonaAsociada() {
        return zonaAsociada;
    }

    public void setZonaAsociada(Zona zonaAsociada) {
        this.zonaAsociada = zonaAsociada;
    }

    public String getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(String idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Event getEventoAsociado() {
        return eventoAsociado;
    }

    public void setEventoAsociado(Event eventoAsociado) {
        this.eventoAsociado = eventoAsociado;
    }

    public Asiento getAsientoAsociado() {
        return asientoAsociado;
    }

    public void setAsientoAsociado(Asiento asientoAsociado) {
        this.asientoAsociado = asientoAsociado;
    }

    public TipoZona getCategoriaEntrada() {
        return categoriaEntrada;
    }

    public void setCategoriaEntrada(TipoZona categoriaEntrada) {
        this.categoriaEntrada = categoriaEntrada;
    }

    public EstadoEntrada getEstadoEntrada() {
        return estadoEntrada;
    }

    public void setEstadoEntrada(EstadoEntrada estadoEntrada) {
        this.estadoEntrada = estadoEntrada;
    }

}
