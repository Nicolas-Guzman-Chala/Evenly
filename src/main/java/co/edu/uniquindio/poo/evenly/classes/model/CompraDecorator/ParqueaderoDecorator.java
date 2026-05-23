package co.edu.uniquindio.poo.evenly.classes.model.CompraDecorator;



public class ParqueaderoDecorator extends CompraDecorator {

    public ParqueaderoDecorator(CompraComponent compra) {
        super(compra);
    }
    @Override
    public double calcularTotal() {
        return compra.calcularTotal() + 10000;
    }

    @Override
    public String mostrarDescripcion() {
        return compra.mostrarDescripcion()
                + "\n\n=== SERVICIO DE PARQUEADERO ==="
                + "\nEl servicio de parqueadero ha sido agregado"
                + "\na su compra."
                + "\nIncluye acceso a zonas autorizadas de"
                + "\nestacionamiento cercanas al recinto del evento."
                + "\nAdemás, ofrece mayor comodidad y seguridad"
                + "\ndurante su experiencia en el evento.";
    }
}
