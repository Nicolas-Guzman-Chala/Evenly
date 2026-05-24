package co.edu.uniquindio.poo.evenly.classes.model.Proxy;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

public class CompraServiceReal implements CompraService {

    @Override
    public void realizarCompra(Compra compra) {

        compra.getEstado().confirmar(compra);

        System.out.println("Compra creada y confirmada correctamente");
    }

    @Override
    public void cancelarCompra(Compra compra) {

        compra.getEstado().cancelar(compra);

        System.out.println("Solicitud de cancelación procesada");
    }

    @Override
    public void pagarCompra(Compra compra) {

        compra.getEstado().pagar(compra);

        System.out.println("Pago procesado correctamente");
    }

    @Override
    public void consultarCompra(Compra compra) {

        System.out.println(compra.mostrarDescripcion());
    }
}