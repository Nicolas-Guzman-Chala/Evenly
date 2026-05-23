package co.edu.uniquindio.poo.evenly.classes.model;

import java.time.LocalDate;

public class Incidencia {
    private String idIncidencia;
    private String tipoIncidencia;
    private String descripcion;
    private LocalDate fecha;
    private boolean resuelta;
    private Compra compraAsociada;

    public Incidencia(String idIncidencia, String tipoIncidencia, String descripcion, LocalDate fecha, Compra compraAsociada) {
        this.idIncidencia = idIncidencia;
        this.tipoIncidencia = tipoIncidencia;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.compraAsociada = compraAsociada;
        this.resuelta = false;
    }

    /**
     * Marca la incidencia como resuelta
     */
    public void resolverIncidencia(){
        resuelta = true;
        System.out.println(
                "La incidencia ha sido resuelta"
        );
    }
    /**
     * Consulta la información de la incidencia
     */
    public String consultarIncidencia(){

        return "=== INCIDENCIA ==="
                + "\nID: " + idIncidencia
                + "\nTipo: " + tipoIncidencia
                + "\nDescripción: " + descripcion
                + "\nFecha: " + fecha
                + "\nResuelta: " + resuelta
                + "\nCompra Asociada: "
                + compraAsociada.getIdCompra();
    }

    public String getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(
            String idIncidencia) {

        this.idIncidencia = idIncidencia;
    }

    public String getTipoIncidencia() {
        return tipoIncidencia;
    }

    public void setTipoIncidencia(
            String tipoIncidencia) {

        this.tipoIncidencia = tipoIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(
            String descripcion) {

        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(
            LocalDate fecha) {

        this.fecha = fecha;
    }

    public boolean isResuelta() {
        return resuelta;
    }

    public void setResuelta(
            boolean resuelta) {

        this.resuelta = resuelta;
    }

    public Compra getCompraAsociada() {
        return compraAsociada;
    }

    public void setCompraAsociada(
            Compra compraAsociada) {

        this.compraAsociada = compraAsociada;
    }
}