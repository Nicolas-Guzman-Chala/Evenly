package co.edu.uniquindio.poo.evenly.classes.model.EventFactoryDTO;

import co.edu.uniquindio.poo.evenly.classes.model.Concierto;
import co.edu.uniquindio.poo.evenly.classes.model.Event;

import java.util.UUID;

public class ConciertoFactoryDTO
        implements EventFactoryDTO {

    @Override
    public Event createEventDTO(
            CreateEventDTO dto
    ) {

        return new Concierto(
                UUID.randomUUID().toString(),

                dto.name(),

                dto.city(),

                dto.date(),

                dto.hour(),

                dto.state(),

                "",

                dto.imagePath(),

                "",

                "",

                dto.recinto(),
                dto.price()
        );
    }
}
