package co.edu.uniquindio.poo.evenly.classes.model.Factory;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEvento;
import co.edu.uniquindio.poo.evenly.classes.model.Event;

import java.time.LocalDate;

public interface EventFactory {

    Event createEvent(
            String name,
            Cities city,
            LocalDate date,
            String hour,
            EstadoEvento state,
            String imagePath,
            double price
    );
}