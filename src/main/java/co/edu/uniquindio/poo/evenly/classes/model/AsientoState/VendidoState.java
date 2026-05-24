package co.edu.uniquindio.poo.evenly.classes.model.AsientoState;

import co.edu.uniquindio.poo.evenly.classes.model.Seat;

public class VendidoState
        implements AsientoState {

    @Override
    public boolean reservar(
            Seat asiento
    ) {

        return false;
    }

    @Override
    public boolean comprar(
            Seat asiento
    ) {

        return false;
    }

    @Override
    public boolean liberar(
            Seat asiento
    ) {

        return false;
    }

    @Override
    public boolean bloquear(
            Seat asiento
    ) {

        asiento.setState(
                new BloqueadoState()
        );

        return true;
    }

    @Override
    public boolean vender(
            Seat asiento
    ) {

        return false;
    }

    @Override
    public boolean isAvailable() {

        return false;
    }

    @Override
    public String getNombreEstado() {

        return "Vendido";
    }
}