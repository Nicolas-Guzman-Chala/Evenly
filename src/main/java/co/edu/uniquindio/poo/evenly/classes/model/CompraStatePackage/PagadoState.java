package co.edu.uniquindio.poo.evenly.classes.model.CompraStatePackage;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

public class PagadoState implements CompraState {

    @Override
    public void pagar(Compra compra) {
        System.out.println(" la compra ya esta Pagada");
    }

    @Override
    public void confirmar(Compra compra) {

        compra.setEstado(new ConfirmadoState());

        System.out.println("La compra ha sido confirmada");
    }

    @Override
    public void cancelar(Compra compra) {
        System.out.println("la compra ya esta Pagada");
    }


    @Override
    public void reembolsar(Compra compra) {
     compra.setEstado(new ReembolsadaState());
     System.out.println("la compra ha sido reembolsada");
    }

    @Override
    public void reportarIncidencia(Compra compra) {
        compra.setEstado(new IncidenciaState());
        System.out.println("la compra ha sido reportada");
    }
}
