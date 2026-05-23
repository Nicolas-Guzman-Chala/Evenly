package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.AsientoState.AsientoState;
import co.edu.uniquindio.poo.evenly.classes.model.AsientoState.DisponibleState;
import co.edu.uniquindio.poo.evenly.classes.model.Composite.ComponenteZona;

public class Asiento implements ComponenteZona {
    private String idAsiento;
    private String fila;
    private int numero;
    private AsientoState estado;
    public Asiento(String idAsiento, String fila, int numero){
        this.idAsiento = idAsiento;
        this.fila = fila;
        this.numero = numero;
        this.estado = new DisponibleState();
    }


    public String getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(String idAsiento) {
        this.idAsiento = idAsiento;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public AsientoState getEstado() {
        return estado;
    }

    public void setEstado(AsientoState estado) {
        this.estado = estado;
    }

    @Override
    public String mostrarInformacion() {

        return "ASIENTO" +
                "\nID: " + idAsiento +
                "\nFila: " + fila +
                "\nNumero: " + numero +
                "\nEstado: " + estado;
    }


    public void consultarEstado() {
        System.out.println(estado);
    }
}
