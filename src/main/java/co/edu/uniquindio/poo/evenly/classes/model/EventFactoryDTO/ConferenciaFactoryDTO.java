package co.edu.uniquindio.poo.evenly.classes.model.EventFactoryDTO;

import co.edu.uniquindio.poo.evenly.classes.model.EventFactoryDTO.CreateEventDTO;
import co.edu.uniquindio.poo.evenly.classes.model.Conferencia;
import co.edu.uniquindio.poo.evenly.classes.model.Event;

import java.util.UUID;

public class ConferenciaFactoryDTO
        implements EventFactoryDTO {

    @Override
    public Event createEventDTO(
            CreateEventDTO dto
    ) {

        return new Conferencia(
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
