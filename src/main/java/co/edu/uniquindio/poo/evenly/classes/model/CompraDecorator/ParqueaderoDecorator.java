package co.edu.uniquindio.poo.evenly.classes.model.CompraDecorator;

public class ParqueaderoDecorator extends CompraDecorator {

    public ParqueaderoDecorator(CompraComponent compra) {
        super(compra);
    }

    @Override
    public double calcularTotal() {
        return super.calcularTotal() + 10000;
    }

    @Override
    public String mostrarDescripcion() {
        return super.mostrarDescripcion() +
                "\n\n=== PARQUEADERO ===" +
                "\nAcceso a zonas de estacionamiento seguras";
    }
}
