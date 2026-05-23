package co.edu.uniquindio.poo.evenly.classes.model.CompraStrategy;

public class PagoPSE implements PagoStrategy {
    @Override
    public void procesarPago(double total) {
        System.out.println("Pago con PSE realizado por: $" + total);
    }
}
