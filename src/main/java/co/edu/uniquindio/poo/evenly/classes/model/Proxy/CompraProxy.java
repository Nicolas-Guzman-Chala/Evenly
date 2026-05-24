package co.edu.uniquindio.poo.evenly.classes.model.Proxy;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;
import co.edu.uniquindio.poo.evenly.classes.model.UserSession;

public class CompraProxy implements CompraService {

    private final CompraService service;

    public CompraProxy(CompraService service) {
        this.service = service;
    }

    private boolean tieneAcceso() {
        return UserSession.getCurrentUser() != null;
    }

    private boolean validarCompra(Compra compra) {

        return compra != null
                && compra.getIdUser()!= 0
                && compra.getEvento() != null;
    }

    private boolean validarEntradas(Compra compra) {

        return compra.getEntradas() != null
                && !compra.getEntradas().isEmpty();
    }

    private void denegar(String accion) {
        System.out.println("Acceso denegado a: " + accion);
    }

    @Override
    public void realizarCompra(Compra compra) {

        if (tieneAcceso() && validarCompra(compra) && validarEntradas(compra)) {
            service.realizarCompra(compra);
        } else {
            denegar("realizar compra");
        }
    }

    @Override
    public void cancelarCompra(Compra compra) {

        if (tieneAcceso() && validarCompra(compra)) {
            service.cancelarCompra(compra);
        } else {
            denegar("cancelar compra");
        }
    }

    @Override
    public void pagarCompra(Compra compra) {

        if (tieneAcceso() && validarCompra(compra) && validarEntradas(compra)) {
            service.pagarCompra(compra);
        } else {
            denegar("pagar compra");
        }
    }

    @Override
    public void consultarCompra(Compra compra) {

        if (tieneAcceso() && validarCompra(compra)) {
            service.consultarCompra(compra);
        } else {
            denegar("consultar compra");
        }
    }
}