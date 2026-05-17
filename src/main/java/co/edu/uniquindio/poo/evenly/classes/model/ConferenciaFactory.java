package co.edu.uniquindio.poo.evenly.classes.model;

import java.time.LocalDate;

public class ConferenciaFactory implements EventFactory {
private String presentador;
private String tema;
public  ConferenciaFactory(String presentador, String tema) {
    this.presentador = presentador;
    this.tema = tema;
}

    @Override
    public Event createEvent(int id,  String name, Cities city, LocalDate date, String hour, String category, EstadoEvento state, String description, String imagePath) {
        return new Conferencia(presentador, tema, id, name, city, date, hour, category, state, description, imagePath);
    }
}
