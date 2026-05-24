package co.edu.uniquindio.poo.evenly;

import java.time.LocalDate;

public class SaleDTO {

    private String userName;
    private LocalDate date;
    private double total;

    public SaleDTO(String userName, LocalDate date, double total) {
        this.userName = userName;
        this.date = date;
        this.total = total;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTotal() {
        return total;
    }
}