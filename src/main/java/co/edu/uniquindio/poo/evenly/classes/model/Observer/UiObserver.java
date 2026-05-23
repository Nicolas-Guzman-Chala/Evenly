package co.edu.uniquindio.poo.evenly.classes.model.Observer;

public class UiObserver implements Observer {
    @Override
    public void update(String mensaje) {

        System.out.println("Actualizando interfaz: " + mensaje);
    }
}
