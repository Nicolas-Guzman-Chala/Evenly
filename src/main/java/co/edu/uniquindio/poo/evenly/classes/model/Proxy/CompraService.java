package co.edu.uniquindio.poo.evenly.classes.model.Proxy;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

public interface CompraService {

    void realizarCompra(Compra compra);

    void cancelarCompra(Compra compra);

    void pagarCompra(Compra compra);

    void consultarCompra(Compra compra);
}