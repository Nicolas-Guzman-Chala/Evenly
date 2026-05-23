package co.edu.uniquindio.poo.evenly.classes.model.CompraDecorator;


public class SeguroDecorator extends CompraDecorator{
    public SeguroDecorator(CompraComponent compra) {
        super(compra);
    }
    @Override
    public String mostrarDescripcion() {
        return  compra.mostrarDescripcion() +
                "\n\n=== SERVICIO DE SEGURO ==="
                + "\nEl seguro de compra ha sido activado."
                + "\nEste servicio brinda protección ante"
                + "\ncancelaciones, errores en la compra,"
                + "\nreembolsos y situaciones imprevistas."
                + "\nAdemás, ofrece prioridad en la atención"
                + "\ny soporte especializado para incidencias.";
    }

    @Override
    public double calcularTotal() {
        return compra.calcularTotal() + 30000;
    }
}
