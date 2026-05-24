package co.edu.uniquindio.poo.evenly.classes.model.CompraStatePackage;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

public class CanceladaState implements CompraState {

    @Override
    public void pagar(Compra compra) {
        System.out.println("No se puede pagar: compra cancelada");
    }

    @Override
    public void confirmar(Compra compra) {
        System.out.println("No se puede confirmar: compra cancelada");
    }

    @Override
    public void cancelar(Compra compra) {
        System.out.println("La compra ya está cancelada");
    }

    @Override
    public void reembolsar(Compra compra) {
        System.out.println("Procesando reembolso desde estado cancelado");
    }

    @Override
    public void reportarIncidencia(Compra compra) {
        System.out.println("No se puede reportar incidencia: compra cancelada");
    }
}
