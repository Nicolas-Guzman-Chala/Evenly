package co.edu.uniquindio.poo.evenly.classes.model.EventFactoryDTO;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.CategoriaEvento;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEvento;
import co.edu.uniquindio.poo.evenly.classes.model.Recinto;

import java.time.LocalDate;

public record CreateEventDTO(

        String name,

        Cities city,

        LocalDate date,

        String hour,

        CategoriaEvento category,

        EstadoEvento state,

        String imagePath,

        Recinto recinto,

        double price

) {
}
