package co.edu.uniquindio.poo.evenly.classes.model.CompraStrategy;

public class PagoPaypal implements PagoStrategy{
    @Override
    public void procesarPago(double total) {
        System.out.println("Pago con paypal realizado por: $" + total);
    }
}
