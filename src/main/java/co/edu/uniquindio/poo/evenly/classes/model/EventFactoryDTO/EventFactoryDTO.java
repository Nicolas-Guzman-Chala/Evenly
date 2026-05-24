package co.edu.uniquindio.poo.evenly.classes.model.EventFactoryDTO;

import co.edu.uniquindio.poo.evenly.classes.model.Event;

public interface EventFactoryDTO {

    Event createEventDTO(
            CreateEventDTO dto
    );
}
