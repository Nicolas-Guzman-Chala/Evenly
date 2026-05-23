package co.edu.uniquindio.poo.evenly.classes.model.Observer;

import co.edu.uniquindio.poo.evenly.classes.model.Compra;
import co.edu.uniquindio.poo.evenly.classes.model.CompraStatePackage.CanceladaState;
import co.edu.uniquindio.poo.evenly.classes.model.CompraStatePackage.ReembolsadaState;

import java.util.ArrayList;
import java.util.List;

public class CompraServiceObserver {

    private List<Observer> observers;

    private List<Compra> compras;

    public CompraServiceObserver() {

        this.observers = new ArrayList<>();

        this.compras = new ArrayList<>();
    }

    /**
     * Agrega observers al servicio
     */
    public void addObserver(
            Observer observer){

        observers.add(observer);
    }

    /**
     * Elimina observers
     */
    public void removeObserver(
            Observer observer){

        observers.remove(observer);
    }

    /**
     * Notifica a todos los observers
     */
    public void notifyObservers(
            String mensaje){

        for(Observer observer : observers){

            observer.update(mensaje);
        }
    }

    /**
     * Realiza una compra
     */
    public void realizarCompra(
            Compra compra){

        compras.add(compra);

        compra.getEstado().confirmar(compra);

        notifyObservers(
                "Nueva compra realizada: "
                        + compra.getIdCompra()
        );

        System.out.println(
                "Compra realizada correctamente"
        );
    }

    /**
     * Cancela una compra
     */
    public void cancelarCompra(
            Compra compra){

        compra.setEstado(
                new CanceladaState()
        );

        notifyObservers(
                "Compra cancelada: "
                        + compra.getIdCompra()
        );

        System.out.println(
                "Compra cancelada"
        );
    }

    /**
     * Registra un reembolso
     */
    public void registrarReembolso(
            Compra compra){

        compra.setEstado(
                new ReembolsadaState()
        );

        notifyObservers(
                "Compra reembolsada: "
                        + compra.getIdCompra()
        );

        System.out.println(
                "Reembolso realizado"
        );
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(
            List<Observer> observers) {

        this.observers = observers;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(
            List<Compra> compras) {

        this.compras = compras;
    }
}