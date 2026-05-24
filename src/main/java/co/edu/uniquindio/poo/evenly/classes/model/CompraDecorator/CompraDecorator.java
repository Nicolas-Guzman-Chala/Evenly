package co.edu.uniquindio.poo.evenly.classes.model.CompraDecorator;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

public abstract class CompraDecorator implements  CompraComponent {
    protected CompraComponent compra;

    public  CompraDecorator(CompraComponent compra) {
        this.compra = compra;
    }
    @Override
    public String mostrarDescripcion() {
    return  compra.mostrarDescripcion();
    }

    @Override
    public double calcularTotal() {
        return compra.calcularTotal();
    }

}
