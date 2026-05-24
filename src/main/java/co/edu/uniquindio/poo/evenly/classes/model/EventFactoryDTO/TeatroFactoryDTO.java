package co.edu.uniquindio.poo.evenly.classes.model.EventFactoryDTO;

import co.edu.uniquindio.poo.evenly.classes.model.Event;
import co.edu.uniquindio.poo.evenly.classes.model.Teatro;

import java.util.UUID;

public class TeatroFactoryDTO
        implements EventFactoryDTO {

    @Override
    public Event createEventDTO(
            CreateEventDTO dto
    ) {

        return new Teatro(
                "",
                "",
                "",
                "",

                UUID.randomUUID().toString(),

                dto.name(),

                dto.city(),

                dto.date(),

                dto.hour(),

                dto.state(),

                "",

                dto.imagePath(),

                dto.recinto(),
                dto.price()
        );
    }
}
