package co.edu.uniquindio.poo.evenly.classes.model.Observer;

public class UsuarioObserver implements Observer {


    @Override
    public void update(String mensaje){
        System.out.println("Usuario notificado: " + mensaje);
    }
}
