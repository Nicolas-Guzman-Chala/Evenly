package co.edu.uniquindio.poo.evenly.classes.model.Observer;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class UiObserver implements Observer<Object> {

    private Label label;

    public UiObserver(Label label) {
        this.label = label;
    }

    @Override
    public void update(String mensaje, Object data) {

        Platform.runLater(() -> {
            label.setText(mensaje);
        });

        System.out.println("[UI] " + mensaje);
    }
}