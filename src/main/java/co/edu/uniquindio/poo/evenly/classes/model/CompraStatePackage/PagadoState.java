package co.edu.uniquindio.poo.evenly.classes.model.CompraStatePackage;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

public class PagadoState implements CompraState {

    @Override
    public void pagar(Compra compra) {
        System.out.println("La compra ya está pagada");
    }

    @Override
    public void confirmar(Compra compra) {

        compra.setEstado(new ConfirmadoState());

        System.out.println("Compra pagada → confirmada");
    }

    @Override
    public void cancelar(Compra compra) {

        compra.setEstado(new CanceladaState());

        System.out.println("Compra pagada → cancelada");
    }

    @Override
    public void reembolsar(Compra compra) {

        compra.setEstado(new ReembolsadaState());

        System.out.println("Compra pagada → reembolsada");
    }

    @Override
    public void reportarIncidencia(Compra compra) {

        compra.setEstado(new IncidenciaState());

        System.out.println("Compra pagada → incidencia");
    }
}
