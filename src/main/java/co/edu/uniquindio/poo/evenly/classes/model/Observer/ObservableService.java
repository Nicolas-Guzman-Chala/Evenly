package co.edu.uniquindio.poo.evenly.classes.model.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableService<T> {

    protected List<Observer<T>> observers = new ArrayList<>();

    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String mensaje, T data) {
        for (Observer<T> o : observers) {
            o.update(mensaje, data);
        }
    }
}