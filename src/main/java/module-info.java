module co.edu.uniquindio.poo.evenly {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires com.google.gson;
    requires org.apache.pdfbox;

    opens co.edu.uniquindio.poo.evenly
            to javafx.fxml;

    opens co.edu.uniquindio.poo.evenly.classes.model
            to com.google.gson, javafx.base;

    exports co.edu.uniquindio.poo.evenly;
    opens co.edu.uniquindio.poo.evenly.classes.model.ENUMS to com.google.gson;
}