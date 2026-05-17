package co.edu.uniquindio.poo.evenly.classes.model;

import java.time.LocalDate;

public class Conferencia extends Event{
    private String presentador;
    private String tema;
    public Conferencia(String presentador,  String tema,  int id,
                       String name,
                       Cities city,
                       LocalDate date,
                       String hour,
                       String category,
                       EstadoEvento state, String description, String imagePath) {
        super(id,name,city,date,hour,category,state,description,imagePath);
        this.presentador = presentador;
        this.tema = tema;
    }

    public String getPresentador() {
        return presentador;
    }

    public void setPresentador(String presentador) {
        this.presentador = presentador;
    }



    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
