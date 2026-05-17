package co.edu.uniquindio.poo.evenly.classes.model;

import java.time.LocalDate;

public interface  EventFactory {
    Event createEvent(
            int id,
            String name,
            Cities city,
            LocalDate date,
            String hour,
            String category,
            EstadoEvento state,
            String description,
            String imagePath
    );
}


