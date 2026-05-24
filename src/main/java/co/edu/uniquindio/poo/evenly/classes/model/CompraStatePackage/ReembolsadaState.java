package co.edu.uniquindio.poo.evenly.classes.model.CompraStatePackage;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

public class ReembolsadaState implements CompraState {

    @Override
    public void pagar(Compra compra) {
        System.out.println("Acción inválida: la compra ya fue reembolsada");
    }

    @Override
    public void confirmar(Compra compra) {
        System.out.println("Acción inválida: la compra ya fue reembolsada");
    }

    @Override
    public void cancelar(Compra compra) {
        System.out.println("Acción inválida: la compra ya fue reembolsada");
    }

    @Override
    public void reembolsar(Compra compra) {
        System.out.println("La compra ya se encuentra reembolsada");
    }

    @Override
    public void reportarIncidencia(Compra compra) {
        System.out.println("No se puede reportar incidencia: compra reembolsada");
    }
}