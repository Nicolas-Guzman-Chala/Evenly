package co.edu.uniquindio.poo.evenly.classes.model.AsientoState;

import co.edu.uniquindio.poo.evenly.classes.model.Asiento;

public class VendidoState implements AsientoState {
    @Override
    public void reservar(Asiento asiento) {
        System.out.println("el asiento ya esta vendido, no se puede reservar");
    }

    @Override
    public void comprar(Asiento asiento) {
   System.out.println("el asiento ya esta comprado");
    }

    @Override
    public void liberar(Asiento asiento) {
      System.out.println("el asiento ya esta comprado, no se puede liberar");
    }

    @Override
    public void bloquear(Asiento asiento) {
     asiento.setEstado(new BloqueadoState());
     System.out.println("el asiento ha sido bloqueado, lamentamos los inconvenientes");
    }

    @Override
    public String toString() {
        return "Vendido";
    }
}
