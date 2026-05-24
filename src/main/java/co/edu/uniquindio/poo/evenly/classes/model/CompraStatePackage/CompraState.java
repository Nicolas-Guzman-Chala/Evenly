package co.edu.uniquindio.poo.evenly.classes.model.CompraStatePackage;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

public interface CompraState {

    void pagar(Compra compra);

    void confirmar(Compra compra);

    void cancelar(Compra compra);

    void reembolsar(Compra compra);

    void reportarIncidencia(Compra compra);
}