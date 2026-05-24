package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.CategoriaEvento;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEvento;

import java.time.LocalDate;
import java.time.LocalTime;

public class Teatro extends Event {

    private String autor;

    private String director;

    private String actores;

    private String tema;

    public Teatro(
            String autor,
            String director,
            String actores,
            String tema,
            String id,
            String name,
            Cities city,
            LocalDate date,
            String hour,
            EstadoEvento state,
            String description,
            String imagePath,
            Recinto recinto,
            double price
    ) {

        super(
                id,
                name,
                city,
                date,
                hour,
                CategoriaEvento.TEATRO,
                state,
                description,
                imagePath,
                recinto,
                price
        );

        this.autor = autor;
        this.director = director;
        this.actores = actores;
        this.tema = tema;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}