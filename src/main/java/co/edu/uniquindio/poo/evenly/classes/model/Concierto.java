package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.CategoriaEvento;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEvento;

import java.time.LocalDate;
import java.time.LocalTime;

public class Concierto extends Event {

    private String artista;

    private String descripcionArtista;

    public Concierto(
            String id,
            String name,
            Cities city,
            LocalDate date,
            String hour,
            EstadoEvento state,
            String description,
            String imagePath,
            String artista,
            String descripcionArtista,
            Recinto recinto,
            double price
    ) {

        super(
                id,
                name,
                city,
                date,
                hour,
                CategoriaEvento.CONCIERTO,
                state,
                description,
                imagePath,
                recinto,
                price

        );

        this.artista = artista;
        this.descripcionArtista = descripcionArtista;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getDescripcionArtista() {
        return descripcionArtista;
    }

    public void setDescripcionArtista(
            String descripcionArtista
    ) {

        this.descripcionArtista =
                descripcionArtista;
    }
}