package co.edu.uniquindio.poo.evenly.classes.model.CompraDecorator;


public class VIPDecorator extends CompraDecorator {

    public VIPDecorator(CompraComponent compra) {
        super(compra);
    }

    @Override
    public double calcularTotal() {

        return compra.calcularTotal()
                + 80000;
    }

    @Override
    public String mostrarDescripcion() {

        return compra.mostrarDescripcion()
                + "\nBeneficios VIP incluidos:"
                + "\n- Acceso prioritario"
                + "\n- Zona lounge"
                + "\n- Bebida gratuita"
                + "\n- Seguro premium incluido"
                + "\n- Parqueadero incluido";
    }
}