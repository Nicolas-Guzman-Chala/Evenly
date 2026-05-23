package co.edu.uniquindio.poo.evenly.classes.model.Proxy;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

public class CompraServiceReal implements CompraService {

    @Override
    public void realizarCompra(Compra compra) {

        System.out.println("Compra realizada correctamente");
    }

    @Override
    public void cancelarCompra(
            Compra compra) {

        compra.getEstado().cancelar(compra);
        System.out.println("Compra cancelada");
    }

    @Override
    public void pagarCompra(Compra compra) {

        compra.getMetodoPago().procesarPago(compra.calcularTotal());

        compra.getEstado().pagar(compra);

        System.out.println("Pago realizado correctamente");
    }

    @Override
    public void consultarCompra(Compra compra) {

        System.out.println(compra.mostrarDescripcion());
    }
}