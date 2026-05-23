package co.edu.uniquindio.poo.evenly.classes.model.AsientoState;

import co.edu.uniquindio.poo.evenly.classes.model.Asiento;

public class ReservadoState implements AsientoState {

    @Override
    public void reservar(Asiento asiento) {
        System.out.println("el asiento ya esta reservado");
    }

    @Override
    public void comprar(Asiento asiento) {
      asiento.setEstado(new VendidoState());
      System.out.println("el asiento ha sido comprado");
    }

    @Override
    public void liberar(Asiento asiento) {
     asiento.setEstado(new DisponibleState());
     System.out.println("el asiento ya esta disponible");
    }

    @Override
    public void bloquear(Asiento asiento) {
     asiento.setEstado(new BloqueadoState());
     System.out.println("el asiento ha sido bloqueado");
    }
    @Override
    public String toString() {
        return "Reservado";
    }

}
