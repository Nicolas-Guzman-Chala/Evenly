package co.edu.uniquindio.poo.evenly.classes.model.CompraStatePackage;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

public class IncidenciaState
        implements CompraState {

    @Override
    public void pagar(
            Compra compra) {

        System.out.println(
                "No se puede pagar la compra mientras tenga una incidencia"
        );
    }

    @Override
    public void confirmar(
            Compra compra) {

        System.out.println(
                "No se puede confirmar la compra mientras tenga una incidencia"
        );
    }

    @Override
    public void cancelar(
            Compra compra) {

        compra.setEstado(
                new CanceladaState()
        );

        System.out.println(
                "La compra con incidencia ha sido cancelada"
        );
    }

    @Override
    public void reembolsar(
            Compra compra) {

        compra.setEstado(
                new ReembolsadaState()
        );

        System.out.println(
                "La compra con incidencia ha sido reembolsada"
        );
    }

    @Override
    public void reportarIncidencia(
            Compra compra) {

        System.out.println(
                "La compra ya se encuentra en estado de incidencia"
        );
    }
}