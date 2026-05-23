package co.edu.uniquindio.poo.evenly.classes.model.CompraDecorator;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

public class MerchDecorator extends CompraDecorator{
    public  MerchDecorator(CompraComponent compra) {
        super(compra);
    }
    @Override
    public String mostrarDescripcion() {

        return compra.mostrarDescripcion()
                + "\n\n=== SERVICIO DE MERCHANDISING ==="
                + "\nSe ha agregado acceso preferencial"
                + "\na la zona oficial de merchandising."
                + "\nEste servicio incluye prioridad de ingreso"
                + "\na la tienda del evento y acceso a"
                + "\nproductos exclusivos y ediciones limitadas."
                + "\nAdemás, permite reclamar beneficios"
                + "\ny promociones especiales durante el evento.";
    }
    @Override
    public double calcularTotal()
    {
        return compra.calcularTotal() + 1000;
    }
}
