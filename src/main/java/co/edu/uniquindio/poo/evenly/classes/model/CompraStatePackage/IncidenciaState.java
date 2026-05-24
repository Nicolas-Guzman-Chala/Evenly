package co.edu.uniquindio.poo.evenly.classes.model.CompraStatePackage;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

public class IncidenciaState implements CompraState {

    @Override
    public void pagar(Compra compra) {
        System.out.println("Acción inválida: la compra tiene incidencia");
    }

    @Override
    public void confirmar(Compra compra) {
        System.out.println("Acción inválida: la compra tiene incidencia");
    }

    @Override
    public void cancelar(Compra compra) {

        compra.setEstado(new CanceladaState());

        System.out.println("Compra con incidencia → Cancelada");
    }

    @Override
    public void reembolsar(Compra compra) {

        compra.setEstado(new ReembolsadaState());

        System.out.println("Compra con incidencia → Reembolsada");
    }

    @Override
    public void reportarIncidencia(Compra compra) {
        System.out.println("La compra ya está en estado de incidencia");
    }
}