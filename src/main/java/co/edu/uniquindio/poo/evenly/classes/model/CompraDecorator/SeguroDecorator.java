package co.edu.uniquindio.poo.evenly.classes.model.CompraDecorator;


public class SeguroDecorator extends CompraDecorator {

    public SeguroDecorator(CompraComponent compra) {
        super(compra);
    }

    @Override
    public double calcularTotal() {
        return super.calcularTotal() + 30000;
    }

    @Override
    public String mostrarDescripcion() {
        return super.mostrarDescripcion() +
                "\n\n=== SEGURO ===" +
                "\nCobertura de cancelaciones y reembolsos";
    }
}
