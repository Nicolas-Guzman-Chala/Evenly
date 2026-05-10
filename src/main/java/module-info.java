module co.edu.uniquindio.poo.evenly {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires com.google.gson;

    opens co.edu.uniquindio.poo.evenly
            to javafx.fxml;

    opens co.edu.uniquindio.poo.evenly.classes.model
            to com.google.gson;

    exports co.edu.uniquindio.poo.evenly;
}