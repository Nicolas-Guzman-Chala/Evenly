package co.edu.uniquindio.poo.evenly.classes.model.CompraStatePackage;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

public class CanceladaState implements CompraState{
    @Override
    public void pagar(Compra compra) {
        System.out.print(" la compra ya esta cancelada");
    }

    @Override
    public void confirmar(Compra compra) {
   System.out.print(" la compra ya esta cancelada");
    }

    @Override
    public void cancelar(Compra compra) {
        System.out.print(" la compra ya esta cancelada");
    }

    @Override
    public void reembolsar(Compra compra) {
        System.out.print(" la compra ya esta cancelada");
    }

    @Override
    public void reportarIncidencia(Compra compra) {
        System.out.print(" la compra ya esta cancelada");
    }
}
