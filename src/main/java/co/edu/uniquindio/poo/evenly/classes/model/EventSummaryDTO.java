package co.edu.uniquindio.poo.evenly.classes.model;

public class EventSummaryDTO {

    private String eventName;

    private String city;

    private String date;

    private int ticketsSold;

    private double revenue;

    public EventSummaryDTO(String eventName,
                           String city,
                           String date,
                           int ticketsSold,
                           double revenue) {

        this.eventName = eventName;
        this.city = city;
        this.date = date;
        this.ticketsSold = ticketsSold;
        this.revenue = revenue;
    }

    public String getEventName() {
        return eventName;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public double getRevenue() {
        return revenue;
    }
}
