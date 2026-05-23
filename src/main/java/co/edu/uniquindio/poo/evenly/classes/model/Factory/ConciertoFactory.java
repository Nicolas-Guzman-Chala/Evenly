package co.edu.uniquindio.poo.evenly.classes.model.Factory;

import co.edu.uniquindio.poo.evenly.classes.model.Concierto;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEvento;
import co.edu.uniquindio.poo.evenly.classes.model.Event;

import java.time.LocalDate;

public class ConciertoFactory implements EventFactory {

    private String cantante;
    private String descripcionCantante;

    public ConciertoFactory(
            String cantante,
            String descripcionCantante
    ) {

        this.cantante = cantante;
        this.descripcionCantante = descripcionCantante;
    }

    @Override
    public Event createEvent(
            int id,
            String name,
            Cities city,
            LocalDate date,
            String hour,
            String category,
            EstadoEvento state,
            String description,
            String imagePath
    ) {

        return new Concierto(
                id,
                name,
                city,
                date,
                hour,
                category,
                state,
                description,
                imagePath,
                cantante,
                descripcionCantante
        );
    }
}