package co.edu.uniquindio.poo.evenly.classes.model.Observer;

import java.util.ArrayList;
import java.util.List;

public class UsuarioObserver<T> implements Observer<T> {

    private String nombre;
    private List<String> notificaciones = new ArrayList<>();

    public UsuarioObserver(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void update(String mensaje, T data) {

        String notif = "Usuario " + nombre + ": " + mensaje;

        notificaciones.add(notif);

        System.out.println(notif);
    }

    public List<String> getNotificaciones() {
        return notificaciones;
    }
}