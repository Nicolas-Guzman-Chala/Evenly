package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Rol;
import co.edu.uniquindio.poo.evenly.classes.model.CompraStrategy.PagoStrategy;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int idUser;
    private String fullName;
    private String email;
    private String phone;
    private String password;
    private String imagePath;
    private List<Compra> purchaseHistory = new ArrayList<>();
    private Rol rol;
    private List<PagoStrategy> metodosPago = new ArrayList<>();

    public User(int idUser, String fullName, String email, String phone, String password, String imagePath) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.imagePath = imagePath;
    }

    public List<PagoStrategy> getMetodosPago() {
        return metodosPago;
    }


    public void setMetodosPago(List<PagoStrategy> metodosPago) {
        this.metodosPago = metodosPago;
    }

    public List<Compra> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<Compra> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
