package co.edu.uniquindio.poo.evenly.classes.model.Observer;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEvento;
import co.edu.uniquindio.poo.evenly.classes.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventoService {

    private List<Observer> observers;

    private List<Event> eventos;

    public EventoService() {

        this.observers = new ArrayList<>();

        this.eventos = new ArrayList<>();
    }

    /**
     * Agrega observers
     */
    public void addObserver(
            Observer observer){

        observers.add(observer);
    }

    /**
     * Elimina observers
     */
    public void removeObserver(
            Observer observer){

        observers.remove(observer);
    }

    /**
     * Notifica observers
     */
    public void notifyObservers(
            String mensaje){

        for(Observer observer : observers){

            observer.update(mensaje);
        }
    }

    /**
     * Publica un evento
     */
    public void publicarEvento(
            Event evento){

        evento.setState(
                EstadoEvento.PUBLICADO
        );

        notifyObservers(
                "Evento publicado: "
                        + evento.getName()
        );

        System.out.println(
                "Evento publicado correctamente"
        );
    }

    /**
     * Pausa un evento
     */
    public void pausarEvento(
            Event evento){

        evento.setState(
                EstadoEvento.PAUSADO
        );

        notifyObservers(
                "Evento pausado: "
                        + evento.getName()
        );

        System.out.println(
                "Evento pausado"
        );
    }

    /**
     * Cancela un evento
     */
    public void cancelarEvento(
            Event evento){

        evento.setState(
                EstadoEvento.CANCELADO
        );

        notifyObservers(
                "Evento cancelado: "
                        + evento.getName()
        );

        System.out.println(
                "Evento cancelado"
        );
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(
            List<Observer> observers) {

        this.observers = observers;
    }

    public List<Event> getEventos() {
        return eventos;
    }

    public void setEventos(
            List<Event> eventos) {

        this.eventos = eventos;
    }
}