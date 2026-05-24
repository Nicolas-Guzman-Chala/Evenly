package co.edu.uniquindio.poo.evenly.classes.model.CompraDecorator;

public class MerchDecorator extends CompraDecorator {

    public MerchDecorator(CompraComponent compra) {
        super(compra);
    }

    @Override
    public double calcularTotal() {
        return super.calcularTotal() + 1000;
    }

    @Override
    public String mostrarDescripcion() {
        return super.mostrarDescripcion() +
                "\n\n=== SERVICIO DE MERCHANDISING ===" +
                "\nAcceso prioritario a tienda oficial" +
                "\nProductos exclusivos y ediciones limitadas";
    }
}
