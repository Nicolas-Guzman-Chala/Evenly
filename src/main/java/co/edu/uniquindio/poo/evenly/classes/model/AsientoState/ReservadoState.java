package co.edu.uniquindio.poo.evenly.classes.model.AsientoState;

import co.edu.uniquindio.poo.evenly.classes.model.Seat;

public class ReservadoState
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

        asiento.setState(
                new VendidoState()
        );

        return true;
    }

    @Override
    public boolean liberar(
            Seat asiento
    ) {

        asiento.setState(
                new DisponibleState()
        );

        return true;
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

        asiento.setState(
                new VendidoState()
        );

        return true;
    }

    @Override
    public boolean isAvailable() {

        return false;
    }

    @Override
    public String getNombreEstado() {

        return "Reservado";
    }
}