package co.edu.uniquindio.poo.evenly.classes.model;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.TipoZona;
import co.edu.uniquindio.poo.evenly.classes.model.Composite.ComponenteZona;

import java.util.ArrayList;
import java.util.List;
public class Zona implements ComponenteZona {
    private String idZona;
    private String nombre;
    private int capacidad;
    private double precioBase;
    private List<Asiento> asientos;
    private TipoZona tipo;

    public Zona(String idZona, String nombre, int capacidad, double precioBase, TipoZona tipo) {
        this.idZona = idZona;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioBase = precioBase;
        this.asientos = new ArrayList<>();
        this.tipo = tipo;
    }

    public double calcularTotal(){

        double total = 0;

        for(Asiento asiento : asientos){

            total += precioBase;
        }

        return total;
    }


    public String getIdZona() {
        return idZona;
    }

    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Asiento> asientos) {
        this.asientos = asientos;
    }

    public TipoZona getTipo() {
        return tipo;
    }

    public void setTipo(TipoZona tipo) {
        this.tipo = tipo;
    }

    @Override
    public String mostrarInformacion() {
        return "ZONA: " + nombre +
                "\nID: " + idZona +
                "\nTipo: " + tipo +
                "\nCapacidad: " + capacidad +
                "\nPrecio Base: $" + precioBase +
                "\nCantidad de asientos: " + asientos.size();
    }
}
