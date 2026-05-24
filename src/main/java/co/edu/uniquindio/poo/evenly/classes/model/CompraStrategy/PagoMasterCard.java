package co.edu.uniquindio.poo.evenly.classes.model.CompraStrategy;

public class PagoMasterCard implements  PagoStrategy{


    @Override
    public void procesarPago(double total) {
        System.out.println("Pago con tarjeta realizado por: $" + total);
    }
}
