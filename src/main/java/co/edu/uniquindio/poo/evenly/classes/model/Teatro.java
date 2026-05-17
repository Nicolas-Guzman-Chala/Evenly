package co.edu.uniquindio.poo.evenly.classes.model;

import java.time.LocalDate;

public class Teatro extends Event {
    private String autor;
    private String director;
    private String actores;
    private String tema;
    public Teatro(String Autor, String director, String actores, String tema,   int id,
                  String name,
                  Cities city,
                  LocalDate date,
                  String hour,
                  String category,
                  EstadoEvento state, String description, String imagePath) {
        super(id, name, city, date, hour, category, state, description, imagePath);
        this.autor = Autor;
        this.director = director;
        this.actores = actores;
        this.tema = tema;

    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String Autor) {
        autor = Autor;
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
