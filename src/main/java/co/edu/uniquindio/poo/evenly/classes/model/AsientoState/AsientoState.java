package co.edu.uniquindio.poo.evenly.classes.model.AsientoState;

import co.edu.uniquindio.poo.evenly.classes.model.Asiento;

public interface AsientoState {
     void  reservar(Asiento asiento);
    void  comprar(Asiento asiento);
    void liberar(Asiento asiento);
    void  bloquear(Asiento asiento);
}
