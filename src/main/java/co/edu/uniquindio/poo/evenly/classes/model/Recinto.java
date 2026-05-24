package co.edu.uniquindio.poo.evenly.classes.model;

import co.edu.uniquindio.poo.evenly.classes.model.ENUMS.Cities;

import java.util.ArrayList;
import java.util.List;

public class Recinto {

    private final String idRecinto;

    private String nombre;

    private String direccion;

    private Cities city;

    private final List<Zona> zonas = new ArrayList<>();

    public Recinto(
            String idRecinto,
            String nombre,
            String direccion,
            Cities city
    ) {

        this.idRecinto = idRecinto;
        this.nombre = nombre;
        this.direccion = direccion;
        this.city = city;
    }

    public void agregarZona(Zona zona) {

        if(zona == null){

            throw new IllegalArgumentException(
                    "La zona no puede ser null"
            );
        }

        zonas.add(zona);
    }

    public void eliminarZona(Zona zona) {

        zonas.remove(zona);
    }

    public int getCapacidadTotal() {

        if(zonas == null){
            return 0;
        }

        int total = 0;

        for(Zona zona : zonas){

            if(zona != null){
                total += zona.getCapacidad();
            }
        }

        return total;
    }

    public boolean hasAvailableSeats(){

        if(zonas == null || zonas.isEmpty()){
            return false;
        }

        for(Zona zona : zonas){

            if(zona != null &&
                    zona.hasAvailableSeats()){

                return true;
            }
        }

        return false;
    }

    public int getCantidadZonas(){

        if(zonas == null){
            return 0;
        }

        return zonas.size();
    }

    public String getIdRecinto() {
        return idRecinto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Cities getCity() {
        return city;
    }

    public List<Zona> getZonas() {
        if (zonas == null) {
            return new ArrayList<>();
        }
        return zonas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCity(Cities city) {
        this.city = city;
    }
}