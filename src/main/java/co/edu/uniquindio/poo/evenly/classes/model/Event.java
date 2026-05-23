package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEvento;

import java.time.LocalDate;

public abstract class Event {
    protected int id;
    protected String name;
    protected String description;
    protected String category;
    protected Cities city;
    protected LocalDate date;
    protected String hour;
    protected EstadoEvento state;
    protected Recinto recinto;
    private String imagePath;


    public Event(int id, String name, Cities city, LocalDate date, String hour, String category, EstadoEvento state, String description, String imagePath, Recinto recinto)
    {

        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.hour = hour;
        this.city = city;
        this.date = date;
        this.state = state;
        this.imagePath = imagePath;
        this.recinto = recinto;
    }


    public Recinto getRecinto() {
        return recinto;
    }

    public void setRecinto(Recinto recinto) {
        this.recinto = recinto;
    }

    public boolean publicarEvento(){
        if( state == EstadoEvento.BORRADOR ){
            state=EstadoEvento.PUBLICADO;
           System.out.println("Publicado");
            return true;
        }
        else{
            System.out.println("No puede publicar");
            return false;
        }
}
public boolean cancelarEvento(){
        if( state == EstadoEvento.PUBLICADO || state == EstadoEvento.PAUSADO ){
            state=EstadoEvento.CANCELADO;
            System.out.println("El evento ha sido Cancelado");
            return true;
        } else{
            System.out.println("No puede cancelar");
            return false;
        }
}

public String consultarEvento() {
       String mensaje = " EVENTO: " + name + " \n Descripcion: "  + description + " \n Categoria: " + category + "\n ciudad: "
               + city + " \n fecha:  " + date + " \n hora:  " + hour + "\n estado: " + state;
       return mensaje;
}
// esto toca cambiarlo
    public String consultarDisponibilidadEvento(){

        if(state == EstadoEvento.PUBLICADO){

            return "Este evento está disponible";
        }

        return "Este evento no está disponible";
    }




    public Cities getCity(){
        return city;
    }
    public void setCity(Cities city) {
        this.city = city;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getIdEvent() {
        return id;
    }

    public void setIdEvent(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public EstadoEvento getState() {
        return state;
    }

    public void setState(EstadoEvento estado) {
        this.state = estado;
    }
}