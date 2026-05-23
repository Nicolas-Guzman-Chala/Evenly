package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEvento;

import java.time.LocalDate;

public class Concierto extends Event {
    private String artista;
    private String descripcionArtista;
    public Concierto(int id, String name,
                     Cities city,
                     LocalDate date,
                     String hour,
                     String category,
                     EstadoEvento state, String description, String imagePath, String artista, String descripcionArtista, Recinto recinto)
    {
        super(id, name, city, date, hour,category, state, description, imagePath, recinto );
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

    public void setDescripcionArtista(String descripcionArtista) {
        this.descripcionArtista = descripcionArtista;
    }
}
