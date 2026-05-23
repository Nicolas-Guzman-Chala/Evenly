package co.edu.uniquindio.poo.evenly.classes.model.Observer;

import co.edu.uniquindio.poo.evenly.classes.model.Incidencia;

import java.util.ArrayList;
import java.util.List;

public class IncidenciaService {

    private List<Observer> observers;

    private List<Incidencia> incidencias;

    public IncidenciaService() {

        this.observers = new ArrayList<>();

        this.incidencias = new ArrayList<>();
    }

    /**
     * Registra una incidencia
     */
    public void registrarIncidencia(
            Incidencia incidencia){

        incidencias.add(incidencia);

        System.out.println(
                "Incidencia registrada"
        );

        notificarObservers(
                "Nueva incidencia registrada: "
                        + incidencia.getTipoIncidencia()
        );
    }

    /**
     * Resuelve una incidencia
     */
    public void resolverIncidencia(
            Incidencia incidencia){

        incidencia.resolverIncidencia();

        notificarObservers(
                "Incidencia resuelta: "
                        + incidencia.getIdIncidencia()
        );
    }

    /**
     * Agrega observers
     */
    public void agregarObserver(
            Observer observer){

        observers.add(observer);
    }

    /**
     * Elimina observers
     */
    public void eliminarObserver(
            Observer observer){

        observers.remove(observer);
    }

    /**
     * Notifica observers
     */
    public void notificarObservers(
            String mensaje){

        for(Observer observer : observers){

            observer.update(mensaje);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(
            List<Observer> observers) {

        this.observers = observers;
    }

    public List<Incidencia> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(
            List<Incidencia> incidencias) {

        this.incidencias = incidencias;
    }
}