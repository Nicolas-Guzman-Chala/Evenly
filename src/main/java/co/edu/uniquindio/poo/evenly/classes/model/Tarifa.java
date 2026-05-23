package co.edu.uniquindio.poo.evenly.classes.model;

public class Tarifa {

    private double impuesto;

    private double recargoServicio;

    private double descuento;

    public Tarifa(
            double impuesto,
            double recargoServicio,
            double descuento) {

        this.impuesto = impuesto;

        this.recargoServicio = recargoServicio;

        this.descuento = descuento;
    }

    /**
     * Calcula el precio final aplicando
     * impuestos, recargos y descuentos
     */
    public double calcularPrecioFinal(
            double precioBase){

        return precioBase+ impuesto + recargoServicio - descuento;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getRecargoServicio() {
        return recargoServicio;
    }

    public void setRecargoServicio(double recargoServicio) {
        this.recargoServicio = recargoServicio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}