package co.edu.uniquindio.poo.evenly.classes.model.AsientoState;

import co.edu.uniquindio.poo.evenly.classes.model.Seat;

public interface AsientoState {

    boolean reservar(
            Seat asiento
    );

    boolean comprar(
            Seat asiento
    );

    boolean liberar(
            Seat asiento
    );

    boolean bloquear(
            Seat asiento
    );

    boolean vender(
            Seat asiento
    );

    boolean isAvailable();

    String getNombreEstado();
}