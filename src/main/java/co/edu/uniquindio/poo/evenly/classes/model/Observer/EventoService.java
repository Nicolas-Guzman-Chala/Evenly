package co.edu.uniquindio.poo.evenly.classes.model.Observer;

import co.edu.uniquindio.poo.evenly.classes.model.Event;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEvento;

import java.util.ArrayList;
import java.util.List;

public class EventoService extends ObservableService<Event> {

    private List<Event> eventos = new ArrayList<>();

    public void publicarEvento(Event evento) {

        evento.setState(EstadoEvento.PUBLICADO);

        notifyObservers("Evento publicado", evento);
    }

    public void pausarEvento(Event evento) {

        evento.setState(EstadoEvento.PAUSADO);

        notifyObservers("Evento pausado", evento);
    }

    public void cancelarEvento(Event evento) {

        evento.setState(EstadoEvento.CANCELADO);

        notifyObservers("Evento cancelado", evento);
    }

    public List<Event> getEventos() {
        return eventos;
    }
}