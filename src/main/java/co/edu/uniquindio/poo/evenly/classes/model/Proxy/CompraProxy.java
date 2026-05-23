package co.edu.uniquindio.poo.evenly.classes.model.Proxy;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

public class CompraProxy implements CompraService {

    private CompraServiceReal service;

    public CompraProxy() {

        this.service =
                new CompraServiceReal();
    }

    /**
     * Verifica si la compra puede acceder
     * al servicio
     */
    public boolean verificarAcceso(Compra compra){

        if(compra.getUser() == null){

            System.out.println("Acceso denegado: " + "usuario no válido");
            return false;
        }

        if(compra.getEntradas().isEmpty()){
            System.out.println("Acceso denegado: " + "la compra no tiene entradas");
            return false;
        }

        return true;
    }

    @Override
    public void realizarCompra(Compra compra) {

        if(verificarAcceso(compra)){

            service.realizarCompra(compra);
        }
    }

    @Override
    public void cancelarCompra(Compra compra) {

        if(verificarAcceso(compra)){
            service.cancelarCompra(compra);
        }
    }

    @Override
    public void pagarCompra(Compra compra) {

        if(verificarAcceso(compra)){
            service.pagarCompra(compra);
        }
    }

    @Override
    public void consultarCompra(Compra compra) {

        if(verificarAcceso(compra)){
            service.consultarCompra(compra);
        }
    }
}