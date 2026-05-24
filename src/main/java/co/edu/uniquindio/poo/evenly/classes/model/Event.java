package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.CategoriaEvento;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.EstadoEvento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Event {

    private final String id;

    private String name;

    private String description;

    private final CategoriaEvento category;

    private Cities city;

    private LocalDate date;

    private String hour;

    private EstadoEvento state;

    private Recinto recinto;

    private String imagePath;

    private double price;
    
    private List<Seat> seats = new ArrayList<>();

    public Event(
            String id,
            String name,
            Cities city,
            LocalDate date,
            String hour,
            CategoriaEvento category,
            EstadoEvento state,
            String description,
            String imagePath,
            Recinto recinto,
            double price
    ) {

        this.id = id;
        this.name = name;
        this.city = city;
        this.date = date;
        this.hour = hour;
        this.category = category;
        this.state = state;
        this.description = description;
        this.imagePath = imagePath;
        this.recinto = recinto;
        this.price = price;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public boolean isPublished(){

        return state == EstadoEvento.PUBLICADO;
    }

    public boolean canBeEdited(){

        return state != EstadoEvento.CANCELADO;
    }

    public boolean hasAvailableSeats(){

        if(recinto == null){

            return false;
        }

        return recinto.hasAvailableSeats();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CategoriaEvento getCategory() {
        return category;
    }

    public Cities getCity() {
        return city;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }

    public EstadoEvento getState() {
        return state;
    }

    public Recinto getRecinto() {
        return recinto;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setState(EstadoEvento state) {
        this.state = state;
    }

    public void setRecinto(Recinto recinto) {
        this.recinto = recinto;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}