package co.edu.uniquindio.poo.evenly.classes.model.CompraStatePackage;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

public class ConfirmadoState implements CompraState {

    @Override
    public void pagar(Compra compra) {
        System.out.println("La compra ya fue pagada y confirmada");
    }

    @Override
    public void confirmar(Compra compra) {
        System.out.println("La compra ya está confirmada");
    }

    @Override
    public void cancelar(Compra compra) {

        compra.setEstado(new CanceladaState());

        System.out.println("Compra confirmada → cancelada");
    }

    @Override
    public void reembolsar(Compra compra) {

        compra.setEstado(new ReembolsadaState());

        System.out.println("Compra confirmada → reembolsada");
    }

    @Override
    public void reportarIncidencia(Compra compra) {

        compra.setEstado(new IncidenciaState());

        System.out.println("Compra confirmada → incidencia reportada");
    }
}