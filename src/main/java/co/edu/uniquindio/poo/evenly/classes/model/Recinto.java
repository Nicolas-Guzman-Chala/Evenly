package co.edu.uniquindio.poo.evenly.classes.model;
import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;

import java.util.List;
import java.util.ArrayList;

public class Recinto {

    private String idRecinto;
    private String nombre;
    private String direccion;
    private Cities city;
    private List<Zona> zonas;

    public Recinto(String idRecinto, String nombre, String direccion, Cities city) {
        this.idRecinto = idRecinto;
        this.nombre = nombre;
        this.direccion = direccion;
        this.city = city;
        this.zonas = new ArrayList<>();
    }

    public void agregarZona (Zona zona) {
         zonas.add(zona);
         System.out.println("Zona agregada al recinto");
    }
    public int getCapacidadTotal () {
        int total = 0;
        for (Zona zona  : zonas) {
           int actual =  zona.getCapacidad();
            total += actual;
        }
        return total;
    }
public void eliminarZona (Zona zona) {
        zonas.remove(zona);
        System.out.println("Zona eliminada del recinto");
}
public String verInfo () {
        return  "RECINTO: " + nombre +
                "\nID: " + idRecinto +
                "\nDireccion: " + direccion +
                "\nCiudad: " + city +
                "\nCantidad de zonas: " + zonas.size() +
                "\nCapacidad total: " + getCapacidadTotal();
}

    public String getIdRecinto() {
        return idRecinto;
    }

    public void setIdRecinto(String idRecinto) {
        this.idRecinto = idRecinto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public List<Zona> getZonas() {
        return zonas;
    }

    public void setZonas(List<Zona> zonas) {
        this.zonas = zonas;
    }
}
