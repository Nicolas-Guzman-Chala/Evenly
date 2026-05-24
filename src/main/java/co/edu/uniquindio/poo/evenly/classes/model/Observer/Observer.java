package co.edu.uniquindio.poo.evenly.classes.model.Observer;

public interface Observer<T> {
    void update(String mensaje, T data);
}
