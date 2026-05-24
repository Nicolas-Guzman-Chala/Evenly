package co.edu.uniquindio.poo.evenly.classes.model.AsientoState;

import co.edu.uniquindio.poo.evenly.classes.model.Seat;

public class DisponibleState
        implements AsientoState {

    @Override
    public boolean reservar(
            Seat asiento
    ) {

        asiento.setState(
                new ReservadoState()
        );

        return true;
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

        asiento.setState(
                new VendidoState()
        );

        return true;
    }

    @Override
    public boolean isAvailable() {

        return true;
    }

    @Override
    public String getNombreEstado() {

        return "Disponible";
    }
}