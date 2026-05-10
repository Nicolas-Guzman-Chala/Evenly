package co.edu.uniquindio.poo.evenly;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EvenlyApplication extends Application {

    private EvenlyApplication instance;

    public EvenlyApplication getInstance() {
        return instance;
    }

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(EvenlyApplication.class.getResource("/co/edu/uniquindio/poo/evenly/Events.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Evenly");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    //change scene from fxml stages

    public static void changeScene(String fxml){
        try {
            FXMLLoader loader = new FXMLLoader(
                    EvenlyApplication.class.getResource(
                            "/co/edu/uniquindio/poo/evenly/" + fxml
                    )
            );

            Scene scene = new Scene(loader.load());

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Launcher {
        public static void main(String[] args) {
            Application.launch(args);
        }
    }
}
