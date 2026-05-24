package co.edu.uniquindio.poo.evenly.classes.model.Observer;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;

import java.util.ArrayList;
import java.util.List;

public class CompraServiceObserver extends ObservableService<Compra> {

    private List<Compra> compras = new ArrayList<>();

    public void realizarCompra(Compra compra) {

        compras.add(compra);

        compra.confirmar();

        notifyObservers("Nueva compra realizada", compra);
    }

    public void cancelarCompra(Compra compra) {

        compra.cancelar();

        notifyObservers("Compra cancelada", compra);
    }

    public void registrarReembolso(Compra compra) {

        compra.reembolsar();

        notifyObservers("Compra reembolsada", compra);
    }

    public List<Compra> getCompras() {
        return compras;
    }
}