package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.Composite.ComponenteZona;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.TipoZona;

import java.util.ArrayList;
import java.util.List;

public class Zona implements ComponenteZona {

    private final String idZona;
    private String nombre;
    private int capacidad;
    private double precioBase;
    private final List<Seat> asientos;
    private TipoZona tipo;

    public Zona(String idZona,
                String nombre,
                int capacidad,
                double precioBase,
                TipoZona tipo) {

        this.idZona = idZona;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioBase = precioBase;
        this.tipo = tipo;
        this.asientos = new ArrayList<>();
    }

    public void agregarAsiento(Seat asiento) {

        if (asiento == null) {
            throw new IllegalArgumentException("El asiento no puede ser null");
        }

        if (asientos.size() >= capacidad) {
            throw new IllegalStateException("La zona alcanzó su capacidad máxima");
        }

        asientos.add(asiento);
    }

    public void eliminarAsiento(Seat asiento) {
        asientos.remove(asiento);
    }

    // =========================
    // ESTADÍSTICAS
    // =========================

    public int getCantidadAsientos() {
        return asientos.size();
    }

    public int getAsientosDisponibles() {

        int disponibles = 0;

        for (Seat asiento : asientos) {
            if (asiento.isAvailable()) {
                disponibles++;
            }
        }

        return disponibles;
    }

    public boolean hasAvailableSeats() {
        return getAsientosDisponibles() > 0;
    }

    public double calcularTotal() {

        double total = 0;

        for (Seat asiento : asientos) {

            if (asiento.isAvailable()) {
                total += precioBase;
            }
        }

        return total;
    }

    @Override
    public String mostrarInformacion() {

        return """
                Zona{
                    id='%s',
                    nombre='%s',
                    tipo=%s,
                    capacidad=%d,
                    precioBase=%.2f,
                    asientosTotales=%d,
                    disponibles=%d
                }
                """.formatted(
                idZona,
                nombre,
                tipo,
                capacidad,
                precioBase,
                asientos.size(),
                getAsientosDisponibles()
        );
    }

    public String getIdZona() {
        return idZona;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public List<Seat> getAsientos() {
        return asientos;
    }

    public TipoZona getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public void setTipo(TipoZona tipo) {
        this.tipo = tipo;
    }
}