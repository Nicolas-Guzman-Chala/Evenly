package co.edu.uniquindio.poo.evenly.classes.model.CompraDecorator;


public class VIPDecorator extends CompraDecorator {

    public VIPDecorator(CompraComponent compra) {
        super(compra);
    }

    @Override
    public double calcularTotal() {
        return super.calcularTotal() + 80000;
    }

    @Override
    public String mostrarDescripcion() {
        return super.mostrarDescripcion() +
                "\n\n=== EXPERIENCIA VIP ===" +
                "\nAcceso prioritario" +
                "\nZona lounge" +
                "\nBebidas incluidas" +
                "\nBeneficios premium";
    }
}