package co.edu.uniquindio.poo.evenly.classes.model.Factory;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEvento;
import co.edu.uniquindio.poo.evenly.classes.model.Event;
import co.edu.uniquindio.poo.evenly.classes.model.Teatro;

import java.time.LocalDate;

public class TeatroFactory implements EventFactory {
    private String autor;
    private String director;
    private String actores;
    private String tema;
    public  TeatroFactory(String autor, String director, String actores, String tema) {
        this.autor = autor;
        this.director = director;
        this.actores = actores;
        this.tema = tema;
    }
    @Override
    public Event createEvent(int id, String name, Cities city, LocalDate date, String hour, String category, EstadoEvento state, String description, String imagePath) {
        return new Teatro(autor, director, actores, tema, id, name, city, date, hour, category, state, description, imagePath);
    }
}
