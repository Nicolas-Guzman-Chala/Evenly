package co.edu.uniquindio.poo.evenly;

import co.edu.uniquindio.poo.evenly.classes.model.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;

public class EventCardController {

    private Event event;

    @FXML
    private ImageView imgEventCard;

    @FXML
    private Label textDateEvent;

    @FXML
    private Label textNameEvent;

    @FXML
    private Label textPlaceEvent;

    @FXML
    private Label textPriceEvent;

    @FXML
    private Label textTypeEvent;

    public void setEvent(Event event){

        this.event = event;

        if(event.getImagePath() != null && !event.getImagePath().isEmpty()){

            File file = new File(event.getImagePath());

            imgEventCard.setImage(new Image(file.toURI().toString()));

        }else{

            imgEventCard.setImage(
                    new Image(
                            getClass().getResourceAsStream(
                                    "/co/edu/uniquindio/poo/evenly/imgs/BannerHero.png"
                            )
                    )
            );
        }

        textNameEvent.setText(
                event.getName()
        );

        if(event.getCity() != null){
            textPlaceEvent.setText(event.getCity().toString());
        }else{
            textPlaceEvent.setText("Unknown city");
        }

        textDateEvent.setText(
                event.getDate().toString() + ", " + event.getHour()
        );

        textPriceEvent.setText(
                "$ " + event.getPrice()
        );

        textTypeEvent.setText(
                event.getCategory().toString()
        );

        switch (event.getCategory()) {

            case TEATRO -> {
                textTypeEvent.setText("TEATRO");
                textTypeEvent.setStyle("-fx-background-color: #8B5CF6; -fx-text-fill: white;     -fx-font-family: \"Poppins\";\n" +
                        "    -fx-padding: 5; -fx-background-radius: 5px");
            }

            case CONCIERTO -> {
                textTypeEvent.setText("CONCIERTO");
                textTypeEvent.setStyle("-fx-background-color: #EF4444; -fx-text-fill: white;     -fx-font-family: \"Poppins\";\n" +
                        "    -fx-padding: 5; -fx-background-radius: 5px");
            }

            case CONFERENCIA -> {
                textTypeEvent.setText("CONFERENCIA");
                textTypeEvent.setStyle("-fx-background-color: #3B82F6; -fx-text-fill: white;     -fx-font-family: \"Poppins\";\n" +
                        "    -fx-padding: 5; -fx-background-radius: 5px");
            }
        }
    }

    @FXML
    void onChangeSeeDetails(ActionEvent e) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/co/edu/uniquindio/poo/evenly/SeeDetailsEvent.fxml"
                    )
            );

            Parent root = loader.load();

            SeeDetailsEventController controller =
                    loader.getController();

            controller.setEvent(event);

            Stage stage = (Stage) textNameEvent
                    .getScene()
                    .getWindow();

            stage.setScene(
                    new Scene(root)
            );

            stage.show();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

}

