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
        FXMLLoader fxmlLoader = new FXMLLoader(EvenlyApplication.class.getResource("/co/edu/uniquindio/poo/evenly/Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Evenly");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getStage() {
        return stage;
    }

    //change scene from fxml stages

    public static FXMLLoader changeScene(String fxml){
        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            EvenlyApplication.class.getResource(
                                    "/co/edu/uniquindio/poo/evenly/" + fxml
                            )
                    );

            Scene scene =
                    new Scene(loader.load());

            stage.setScene(scene);

            stage.show();

            return loader;

        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }

    public static class Launcher {
        public static void main(String[] args) {
            Application.launch(args);
        }
    }
}
