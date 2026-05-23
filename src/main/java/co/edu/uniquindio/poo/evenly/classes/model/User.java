package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Rol;
import co.edu.uniquindio.poo.evenly.classes.model.CompraStrategy.PagoStrategy;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String idUser;
    private String fullName;
    private String email;
    private String phone;
    private String password;
    private String imagePath;
    private List<Purchase> purchaseHistory;
    private Rol rol;
    private List<PagoStrategy> metodosPago;

    public User(String idUser, String fullName, String email, String phone, String password, String imagePath, Rol rol) {
        this.idUser = idUser;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.imagePath = imagePath;
        this.rol = rol;
        this.metodosPago = new ArrayList<>();
        this.purchaseHistory = new ArrayList<>();
    }




    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<PagoStrategy> getMetodosPago() {
        return metodosPago;
    }


    public void setMetodosPago(List<PagoStrategy> metodosPago) {
        this.metodosPago = metodosPago;
    }

    public List<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<Purchase> purchaseHistory) {
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
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
