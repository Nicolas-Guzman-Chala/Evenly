package co.edu.uniquindio.poo.evenly.classes.model.AsientoState;

import co.edu.uniquindio.poo.evenly.classes.model.Asiento;

public class BloqueadoState implements AsientoState {

    @Override
    public void reservar(Asiento asiento) {
        System.out.println("el asiento esta Bloqueado, no se puede reservar");
    }

    @Override
    public void comprar(Asiento asiento) {
        System.out.println("el asiento esta Bloqueado, no se puede comprar");
    }

    @Override
    public void liberar(Asiento asiento) {
        asiento.setEstado(new DisponibleState());
        System.out.println("el asiendo ha sido desbloqueado, disponible para uso");
    }

    @Override
    public void bloquear(Asiento asiento) {
     System.out.println("el asiento ya esta bloqueado") ;
    }

    @Override
    public String toString() {
        return "Bloqueado";
    }
}
