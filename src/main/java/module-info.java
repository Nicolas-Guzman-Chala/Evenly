module co.edu.uniquindio.poo.evenly {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires com.google.gson;
    requires java.desktop;

    opens co.edu.uniquindio.poo.evenly
            to javafx.fxml;

    opens co.edu.uniquindio.poo.evenly.classes.model
            to com.google.gson;

    exports co.edu.uniquindio.poo.evenly;
    opens co.edu.uniquindio.poo.evenly.classes.model.CompraStatePackage to com.google.gson;
    opens co.edu.uniquindio.poo.evenly.classes.model.Composite to com.google.gson;
    opens co.edu.uniquindio.poo.evenly.classes.model.AsientoState to com.google.gson;
    opens co.edu.uniquindio.poo.evenly.classes.model.ENUMS to com.google.gson;
    opens co.edu.uniquindio.poo.evenly.classes.model.Factory to com.google.gson;
}