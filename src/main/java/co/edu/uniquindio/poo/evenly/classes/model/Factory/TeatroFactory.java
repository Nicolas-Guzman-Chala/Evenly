package co.edu.uniquindio.poo.evenly.classes.model.Factory;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEvento;
import co.edu.uniquindio.poo.evenly.classes.model.Event;
import co.edu.uniquindio.poo.evenly.classes.model.Teatro;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class TeatroFactory
        implements EventFactory {

    @Override
    public Event createEvent(
            String name,
            Cities city,
            LocalDate date,
            String hour,
            EstadoEvento state,
            String imagePath,
            double price
    ) {

        return new Teatro(
                "",
                "",
                "",
                "",
                UUID.randomUUID().toString(),
                name,
                city,
                date,
                hour,
                state,
                "",
                imagePath,
                null,
                price
        );
    }
}