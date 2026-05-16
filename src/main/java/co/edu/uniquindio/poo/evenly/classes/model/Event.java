package co.edu.uniquindio.poo.evenly.classes.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private int id;
    private String name;
    private String description;
    private CategoriaEvento category;
    private Cities city;
    private LocalDate date;
    private String hour;
    private EstadoEvento state;
    //    private Recinto recinto;
//    private TiposPoliticas politices;
    private int capacity;
    private double price;
    private String imagePath;
    private List<Seat> seats =
            new ArrayList<>();

    public Event(
            int id,
            String name,
                 Cities city,
                 String venue,
                 int capacity,
                 double price,
                 LocalDate date,
                 String hour,
                 CategoriaEvento category,
                 EstadoEvento state, String description, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.hour = hour;
        this.city = city;
        this.date = date;
        this.state = state;
//        this.politices = politices;
        this.capacity = capacity;
        this.price = price;
        this.imagePath = imagePath;
    }

    public List<Seat> getSeats() {
        if(seats == null) {
            seats = new ArrayList<>();
        }

        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    //    public TiposPoliticas getPolitices() {
//        return politices;
//    }
//
//    public void setPolitices(TiposPoliticas politices) {
//        this.politices = politices;
//    }


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

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public CategoriaEvento getCategory() {
        return category;
    }

    public void setCategory(CategoriaEvento category) {
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