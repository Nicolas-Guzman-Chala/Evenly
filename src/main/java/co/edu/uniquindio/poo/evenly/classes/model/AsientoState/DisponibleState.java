package co.edu.uniquindio.poo.evenly.classes.model.AsientoState;

import co.edu.uniquindio.poo.evenly.classes.model.Asiento;

public class DisponibleState implements AsientoState {


    @Override
    public void reservar(Asiento asiento) {
     asiento.setEstado(new ReservadoState());
     System.out.println("el asiento ha sido Reservado");
    }

    @Override
    public void comprar(Asiento asiento) {
        asiento.setEstado(new VendidoState());
        System.out.println("el asiento ha sido Vendido");
    }

    @Override
    public void liberar(Asiento asiento) {
        System.out.println("el asiento ya esta disponible");
    }

    @Override
    public void bloquear(Asiento asiento) {
    asiento.setEstado(new BloqueadoState());
    System.out.println("el asiento ha sido Bloqueado");
    }

    @Override
    public String toString() {
        return "Disponible";
    }
}
